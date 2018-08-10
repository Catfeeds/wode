var util = require('../../utils/util.js');
var app = getApp();
Page({
  data: {
    orderId: 0,
    goodsList: []
  },
  onLoad: function(e) {
    var orderId = e.id;
    this.data.orderId = orderId;
    this.setData({
      orderId: orderId
    });
  },
  dataCode: function(data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatTime(newDate);
  },
  onShow: function() {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/order_info',
      data: {
        id: that.data.orderId
      },
      success: (res) => {
        wx.hideLoading();
        if (res.data.code != 0) {
          wx.showModal({
            title: '错误',
            content: res.data.msg,
            showCancel: false
          })
          return;
        }
        var orderDetail = res.data.data.orderList;
        orderDetail.add_time = that.dataCode(orderDetail.add_time);
        orderDetail.shipping_time = that.dataCode(orderDetail.shipping_time);
        orderDetail.confirm_time = that.dataCode(orderDetail.confirm_time);
        that.setData({
          orderDetail: orderDetail,
          goodsMap: res.data.data.goodsMap
        });
      }
    })
  },

  cancelOrderTap: function(e) {
    var that = this;
    var orderId = e.currentTarget.dataset.id;
    wx.showModal({
      title: '确定要取消该订单吗？',
      content: '',
      success: function(res) {
        if (res.confirm) {
          wx.showLoading();
          wx.request({
            url: app.globalData.subDomain + '/order_cancel',
            data: {
              id: orderId
            },
            success: (res) => {
              wx.hideLoading();
              if (res.data.code == 0) {
                wx.navigateBack({})
                // wx.redirectTo({
                //   url: "/pages/order-list/index"
                // });
              } else {
                wx.showModal({
                  title: '错误',
                  content: res.data.message,
                  showCancel: false
                })
              }
            }
          })
        }
      }
    })
  },
  confirmBtnTap: function(e) { //确认收货按钮点击事件
    var that = this;
    var orderId = e.currentTarget.dataset.id;
    var user_id = wx.getStorageSync('user_id');
    wx.showModal({
      title: '确认您已收到商品？',
      content: '',
      success: function(res) {
        if (res.confirm) {
          //wx.showLoading();
          wx.request({
            url: app.globalData.subDomain + '/order_confirm',
            data: {
              id: orderId,
              user_id: user_id
            },
            success: (res) => {
              if (res.data.code == 0) {
                that.onShow();
              }
            }
          })
        }
      }
    })
  }, //
  toGoodDetailsTap: function(e) {
    wx.navigateTo({
      url: "/pages/goods-details/index?id=" + e.currentTarget.dataset.id
    })
  },
})
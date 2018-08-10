var util = require('../../utils/util.js');
// 引入SDK核心类
var QQMapWX = require('../../utils/qqmap-wx-jssdk.js');
// 实例化API核心类
var qqmapsdk = new QQMapWX({
  key: 'XRWBZ-H7JLS-H37O7-6S45H-SEJRK-FJB7R' // 必填
});
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

  shippingOrderTap: function(e) {
    var that = this;
    var orderId = e.currentTarget.dataset.id;
    var shipping_id = wx.getStorageSync('user_id');
    var shipping_name = app.globalData.userInfo.user_name;
    wx.showModal({
      title: '确定要发货吗？',
      content: '',
      success: function(res) {
        if (res.confirm) {
          wx.showLoading();
          wx.request({
            url: app.globalData.subDomain + '/order_shipping',
            data: {
              id: orderId,
              shipping_id: shipping_id,
              shipping_name: shipping_name
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
  toGoodDetailsTap: function(e) {
    wx.navigateTo({
      url: "/pages/goods-details/index?id=" + e.currentTarget.dataset.id
    })
  },

  toLocTap: function (e) {
    var that = this;
    var addr = "山东省青岛市黄岛区" + e.currentTarget.dataset.addr;
    qqmapsdk.geocoder({
      address: addr,
      success: function (res) {
        var lat = res.result.location.lat;
        var lng = res.result.location.lng;
        wx.openLocation({
          latitude: lat, //坐标纬度（从地图获取坐标）
          longitude: lng, //坐标经度（从地图获取坐标）
          name: addr, //打开后显示的地址名称
          address: addr //打开后显示的地址汉字,
        })
      },
      fail: function (res) {
        console.log(res);
      },
      complete: function (res) {
        console.log(res);
      }
    });
  },
})
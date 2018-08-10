var util = require('../../utils/util.js');
// 引入SDK核心类
var QQMapWX = require('../../utils/qqmap-wx-jssdk.js');
// 实例化API核心类
var qqmapsdk = new QQMapWX({
  key: 'XRWBZ-H7JLS-H37O7-6S45H-SEJRK-FJB7R' // 必填
});
var app = getApp()
Page({
  data: {
    statusType: ["待发货", "待收货", "已完成"],
    statusKey: ["1", "2", "3"],
    currentType: 0,
    currentStatu: "1",
    tabClass: ["", "", ""]
  },
  statusTap: function(e) {
    var curType = e.currentTarget.dataset.index;
    var curStatu = e.currentTarget.dataset.statu;
    this.data.currentType = curType
    this.data.currentStatu = curStatu
    this.setData({
      currentType: curType,
      currentStatu: curStatu
    });
    this.onShow();
  },
  dataCode: function(data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatTime(newDate);
  },
  orderDetail: function(e) {
    var orderId = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: "/pages/order-details-gzt/index?id=" + orderId
    })
  },
  shippingOrderWaterTap: function(e) {
    var that = this;
    var orderId = e.currentTarget.dataset.id;
    var shipping_id = wx.getStorageSync('user_id');
    var shipping_name = app.globalData.userInfo.user_name;
    wx.showModal({
      title: '确定要开始送水吗？',
      content: '',
      success: function(res) {
        if (res.confirm) {
          wx.showLoading();
          wx.request({
            url: app.globalData.subDomain + '/order_water_shipping',
            data: {
              id: orderId,
              shipping_id: shipping_id,
              shipping_name: shipping_name
            },
            success: (res) => {
              wx.hideLoading();
              if (res.data.code == 0) {
                that.onShow();
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
                that.onShow();
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
  onLoad: function(options) {
    // 生命周期函数--监听页面加载
    // console.log(options.order_status);
    // if (options.currentType && options.currentType.length > 0) {
    //   this.setData({
    //     order_status: options.order_status,
    //     currentType: options.currentType,
    //     currentStatu: options.order_status
    //   })
    // }else if(options.order_status) {
    //   this.setData({
    //     order_status: options.order_status,
    //     currentType: options.order_status,
    //     currentStatu: options.order_status
    //   })
    // }
  },
  onReady: function() {
    // 生命周期函数--监听页面初次渲染完成

  },
  onShow: function() {
    // 获取订单列表
    wx.showLoading();
    var that = this;
    var postData = {};
    postData.status = that.data.currentStatu;
    postData.shipping_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/order_list_all',
      data: postData,
      success: (res) => {
        wx.hideLoading();
        if (res.data.code == 0) {
          var datas = res.data.data.orderList;
          var datasW = res.data.data.orderWaterList;
          for (var i = 0; i < datas.length; i++) {
            datas[i].add_time = that.dataCode(datas[i].add_time);
          }
          for (var i = 0; i < datasW.length; i++) {
            datasW[i].add_time = that.dataCode(datasW[i].add_time);
          }
          that.setData({
            orderWaterList: datasW,
            goodsWaterMap: res.data.data.goodsWaterMap,
            orderList: datas,
            goodsMap: res.data.data.goodsMap
          });
        } else {
          this.setData({
            orderWaterList: null,
            goodsWaterMap: {},
            orderList: null,
            goodsMap: {}
          });
        }
      }
    })
  },
  onHide: function() {
    // 生命周期函数--监听页面隐藏

  },
  onUnload: function() {
    // 生命周期函数--监听页面卸载

  },
  onPullDownRefresh: function() {
    // 页面相关事件处理函数--监听用户下拉动作

  },
  onReachBottom: function() {
    // 页面上拉触底事件的处理函数

  },
  makePhoneCall: function(e) {
    var that = this;
    var phone = e.currentTarget.dataset.phone;
    wx.makePhoneCall({
      phoneNumber: phone,
    })
  },
  toLocTap: function(e) {
    var that = this;
    var addr = "山东省青岛市黄岛区" + e.currentTarget.dataset.addr;
    qqmapsdk.geocoder({
      address: addr,
      success: function(res) {
        var lat = res.result.location.lat;
        var lng = res.result.location.lng;
        wx.openLocation({
          latitude: lat, //坐标纬度（从地图获取坐标）
          longitude: lng, //坐标经度（从地图获取坐标）
          name: addr, //打开后显示的地址名称
          address: addr //打开后显示的地址汉字,
        })
      },
      fail: function(res) {
        console.log(res);
      },
      complete: function(res) {
        console.log(res);
      }
    });
  },

})
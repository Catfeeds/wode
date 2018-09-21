//index.js
//获取应用实例
var app = getApp();
var WxParse = require('../../wxParse/wxParse.js');

Page({
  data: {
    autoplay: true,
    interval: 3000,
    duration: 1000,
    goodsDetail: {},
  },

  onLoad: function(e) {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    this.setData({
      user_id: user_id,
    });
    wx.request({
      url: app.globalData.subDomain + '/esxx_detail',
      data: {
        id: e.id
      },
      success: function(res) {
        var selectSizeTemp = "";
        that.data.goodsDetail = res.data.data;
        that.setData({
          goodsDetail: res.data.data
        });
        WxParse.wxParse('article', 'html', res.data.data.goods_desc, that, 5);
      }
    })
  },

  toWant: function () {
    
  },
  
  makePhoneCall: function(e) {
    var phoneNumber = wx.getStorageSync('kefu');
    wx.makePhoneCall({
      phoneNumber: phoneNumber,
    })
  },
  onShareAppMessage: function() {
    var user_id = wx.getStorageSync('user_id');
    return {
      title: this.data.goodsDetail.goods_name,
      path: '/pages/es-details/index?id=' + this.data.goodsDetail.id + '&inviter_id=' + user_id,
      success: function(res) {
        // 转发成功
      },
      fail: function(res) {
        // 转发失败
      }
    }
  }
})
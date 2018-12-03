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
        user_id: user_id,
        id: e.id
      },
      success: function(res) {
        var selectSizeTemp = "";
        var datas = res.data.data;
        var goods_imgs = datas.goods_img.split(',');
        that.data.goodsDetail = datas;
        that.setData({
          zan_list: res.data.data2,
          goodsDetail: datas,
          goods_imgs: goods_imgs

        });
        WxParse.wxParse('article', 'html', datas.goods_desc, that, 5);
      }
    })
  },


  hireXxTap: function(e) {
    var that = this;
    var goodsDetail = this.data.goodsDetail;
    var goods_id = e.currentTarget.dataset.id;
    if (goodsDetail.is_want > 0) {
      return;
    }
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/user_es_goods_want',
      data: {
        user_id: user_id,
        goods_id: goods_id
      },
      success: function(res) {
        wx.showToast({
          title: '已赞美',
          icon: 'success',
          duration: 1000
        })
        goodsDetail.is_want = 1;
        goodsDetail.num_zan += 1;
        that.setData({
          goodsDetail: goodsDetail,
        });
      }
    })
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
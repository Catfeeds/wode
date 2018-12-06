//index.js
//获取应用实例
var util = require('../../utils/util.js');
var app = getApp()
Page({
  data: {
    scores: []
  },
  dataCode: function (data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatTime2(newDate);
  },
  onLoad: function() {},
  onShow: function() {
    this.getMyscores();
  },
  getMyscores: function() {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/user_score_list',
      data: {
        user_id: user_id
      },
      success: function(res) {
        if (res.data.code == 0) {
          var scores = res.data.data;
          for (var i = 0; i < scores.length; i++) {
            scores[i].create_time = that.dataCode(scores[i].create_time);
          }
          if (scores.length > 0) {
            that.setData({
              scores: scores
            });
          }
        }
      }
    })
  },
})
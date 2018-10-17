//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    scores: []
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
// pages/bgxy-detail/index.js
var util = require('../../utils/util.js');
var WxParse = require('../../wxParse/wxParse.js');
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id: 0
  },

  dataCode: function(data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatDate(newDate);
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(e) {
    this.data.id = e.id;
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

    var that = this;
    // 获取帮哥学院文章
    wx.request({
      url: app.globalData.subDomain + '/article_detail',
      method: 'GET',
      data: {
        id: that.data.id
      },
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        wx.hideLoading();
        if (res.data.code == 0) {
          var datas = res.data.data;
          wx.setNavigationBarTitle({
            title: datas.post_title
          })
          datas.published_time = that.dataCode(datas.published_time);
          that.setData({
            bgxywz: datas
          });
          WxParse.wxParse('article', 'html', datas.post_content, that, 5);
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})
// pages/send-msg/show.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var user_id = options.user_id;

    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/paper_crane_count',
      method: 'GET',
      data: {
        user_id: user_id
      },
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        wx.hideLoading();
        if (res.data.code == 0) {
          var count = res.data.data;
          that.setData({
            user_id: user_id,
            count: count
          })
        }
      }
    })
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

  bindSave: function(e) {
    var that = this;
    var user_id = e.detail.value.user_id;
    var score = e.detail.value.score;
    var btn = e.detail.value.score;

    wx.request({
      url: app.globalData.subDomain + '/send_msg' + btn,
      data: {
        user_id: user_id,
        score: score
      },
      success: function(res) {
        wx.hideLoading();
        wx.showModal({
          title: '发送',
          content: '成功',
          showCancel: false
        })
        return;
      }
    })

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})
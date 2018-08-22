var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pages: 1,
    isMoredata: true,
    isHideLoadMore: true,
  },

  /**
   * 跳转发布任务页面
   */
  fabuTask: function(e) {
    wx.navigateTo({
      url: "/pages/es-fbxx/index"
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

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
    wx.request({
      url: app.globalData.subDomain + '/esxx_list',
      data: {
      },
      success: (res) => {
        wx.hideLoading();
        that.setData({
          esxxList: res.data.data
        });
      }
    })
  },

  xxDetailTap: function (e) {

  },

  hireXxTap: function (e) {

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
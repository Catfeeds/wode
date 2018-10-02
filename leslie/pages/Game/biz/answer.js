// pages/biz/answer.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  setRoomCodeIpt: function (e) {
    app.gData.enterCode = e.detail.value;
  },

  enterRoomTap: function () {
    var codeLen = app.gData.enterCode.length;
    if (codeLen == 4) {
      wx.navigateTo({
        url: '../cli/managerProblems?code=' + app.gData.enterCode,
      })
      // 请求后台，如果房间为管理者，那么进入管理页面
      // 请求后台，如果房间为答题者，那么进入答题页面
    } else if (codeLen == 6){
      wx.navigateTo({
        url: '../cli/answerProblems?code=' + app.gData.enterCode,
      })
    }else{
      console.log('to be continued.')
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
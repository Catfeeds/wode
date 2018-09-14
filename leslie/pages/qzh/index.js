// pages/qzh/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    hideShopPopup: true,
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
    var qzh = new Array();
    for (var i = 0; i < 12; i++) {
      var aaa = {}
      aaa.top = Math.round(Math.random() * 900);
      aaa.left = Math.round(Math.random() * 340);
      aaa.jd = Math.round(Math.random() * 20) - 10;
      aaa.img = "/images/1_blue.png";
      qzh.push(aaa);
    }
    this.setData({
      qzh: qzh
    })
  },

  openQzh: function () {
    this.setData({
      hideShopPopup: false
    })
  },

  closePopupTap: function () {
    this.setData({
      hideShopPopup: true
    })
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
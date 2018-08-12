const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    statusType: ["管理员", "普通用户"],
    statusKey: ["0", "1"],
    currentType: 0,
    currentStatu: "0",
  },
  statusTap: function (e) {
    var that = this
    var curType = e.currentTarget.dataset.index;
    var curStatu = e.currentTarget.dataset.statu;
    this.data.currentType = curType
    this.data.currentStatu = curStatu
    this.setData({
      currentType: curType,
      currentStatu: curStatu
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getShenheList()
  },
  //审核列表
  getShenheList: function () {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/yhlb',
      data: {},
      success: function (res) {
        if (res.data.code == 0) {
          that.setData({
            yishenhe: res.data.data.gly,
            weishenhe: res.data.data.ptyh
          })
        }
      }
    })
  },
  //设为管理
  swgl: function (e) {
    var that = this;
    var user_id = e.currentTarget.dataset.id;
    wx.request({
      url: app.globalData.subDomain + '/swgl',
      data: {
        user_id: user_id
      },
      success: function (res) {
        wx.showToast({
          title: '设为管理成功',
          icon: 'success',
          duration: 2000
        })
        that.getShenheList()
      }
    })
  },
  //取消管理
  qxgl: function (e) {
    var that = this;
    var user_id = e.currentTarget.dataset.id;
    wx.request({
      url: app.globalData.subDomain + '/qxgl',
      data: {
        user_id: user_id
      },
      success: function (res) {
        wx.showToast({
          title: '取消管理成功',
          icon: 'success',
          duration: 2000
        })
        that.getShenheList()
      }
    })
  },
  tocallphone: function (e) {
    var phone = e.currentTarget.dataset.phone
    wx.makePhoneCall({
      phoneNumber: phone
    })
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

  },

})
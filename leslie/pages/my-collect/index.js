const app = getApp()
var util = require('../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    statusType: ["我的收藏", "我的赞"],
    statusKey: ["2", "1"],
    currentType: 0,
    currentStatu: "2",
  },
  statusTap: function(e) {
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
  dataCode: function(data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatTime(newDate);
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.getCollectList()
  },
  //我的收藏（赞）列表
  getCollectList: function() {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.showLoading();
    wx.request({
      url: app.globalData.subDomain + '/my_collect_list',
      data: {
        user_id: user_id
      },
      success: function(res) {
        if (res.data.code == 0) {
          var result1 = res.data.data.result1;
          var result2 = res.data.data.result2;
          that.setData({
            result1: result1,
            result2: result2
          })
          wx.hideLoading();
        }
      }
    })
  },

  clickPost: function(e) {
    var id = e.currentTarget.dataset.id;
    var curName = this.data.statusType[this.data.currentType];
    wx.navigateTo({
      url: "../article-detail/index?id=" + id + "&curName=" + curName + "&isBack=1"
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

})
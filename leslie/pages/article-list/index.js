// pages/my-help/index.js

var isclick = false;
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isclick: false,
    currentName: "电影"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    // 获取分类
    wx.request({
      url: app.globalData.subDomain + '/category_list_0',
      method: 'GET',
      data: {
        parent_id: 1
      },
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        if (res.data.code == 0) {
          that.setData({
            statusType: res.data.data,
            currentType: 2,
            isclick: !isclick
          });
          that.loadList();
        }
      }
    })
  },

  statusTap: function(e) {
    var curType = e.currentTarget.dataset.index;
    var curName = e.currentTarget.dataset.name;
    this.data.currentType = curType;
    this.data.currentName = curName;
    this.setData({
      currentType: curType,
      isclick: !isclick
    });
    this.loadList();
  },

  loadList: function() {
    var that = this;
    var tp = that.data.currentType;
    wx.showLoading();
    // 获取分类列表
    wx.request({
      url: app.globalData.subDomain + '/post_list',
      method: 'GET',
      data: {
        category_id: tp
      },
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        wx.hideLoading();
        if (res.data.code == 0) {
          var datas = res.data.data;
          that.setData({
            bgxyList: res.data.data
          });
          // if (res.data.data.length == 0) {
          //   that.setData({
          //     bgxyList: ''
          //   });
          // }
        }
      }
    })
  },

  clickPost: function(e) {
    var id = e.currentTarget.dataset.id;
    var curName = this.data.currentName;
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

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})
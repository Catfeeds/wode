// pages/search/index.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ssButton: "取消",
    buttonClass: "",
    istap: false,
    keyword: "",
    keywordList: []
  },
  // 当键盘输入时
  searchIpt: function(e) {
    if (e.detail.value == "") {
      this.setData({
        ssButton: "取消",
        buttonClass: ""
      })
    } else {
      this.setData({
        ssButton: "确定",
        buttonClass: "main-color-btn",
        keyword: e.detail.value
      })
    }

  },
  buttonTap: function() {
    if (this.data.ssButton == "确定") {
      this.getPostList(this.data.keyword);
    } else {
      wx.switchTab({
        url: '/pages/first-nav/index',
      })
    }
  },
  toSearchTap: function(e) {
    this.setData({
      ssButton: "确定",
      buttonClass: "queding",
      keyword: e.currentTarget.dataset.keyword
    })
  },
  getPostList: function(keyword) {
    var that = this;
    if (this.data.istap) {
      console.log("双击");
      return
    }
    wx.showLoading();
    this.data.istap = true;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/my_collect_list',
      data: {
        keyword: keyword,
        user_id: user_id
      },
      success: function(res) {
        if (res.data.code == 0) {
          var result = res.data.data.result1;
          that.setData({
            result: result
          })
          that.data.istap = false;
          wx.hideLoading();
        }
      },
      fail: function() {
        this.data.istap = false;
        wx.hideLoading();
      }
    })
  },
  clickPost: function(e) {
    var id = e.currentTarget.dataset.id;
    var curName = "搜索";
    wx.navigateTo({
      url: "../article-detail/index?id=" + id + "&curName=" + curName + "&isBack=1"
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    if (options.keyword) {
      this.setData({
        keyword: options.keyword,
      })
    }

    this.getKeywordList();
    this.getPostList(options.keyword);
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {},

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
  getKeywordList: function() {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/keywords',
      data: {},
      success: function(res) {
        that.data.keywordList = res.data.data;
        that.changeKeywords();
      }
    })
  },
  changeKeywords: function() {
    var keywordList = [];
    for (var i = 0; i < this.data.keywordList.length; i++) {
      keywordList[i] = this.data.keywordList[i];
    }
    var keywords = [];
    if (keywordList.length >= 5) {
      for (var i = 0; i < 5; i++) {
        var ran = Math.ceil(Math.random() * keywordList.length) - 1;
        keywords.push(keywordList[ran]);
        keywordList.splice(ran, 1);
      }
    } else {
      keywords = keywordList;
    }

    this.setData({
      keywords: keywords,
    });
  },
  toChangeKeyTap: function(e) {
    this.changeKeywords();
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})
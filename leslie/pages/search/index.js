// pages/search/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ssButton: "取消",
    buttonClass: "",
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
      wx.navigateTo({
        url: "/pages/search-list/index?keyword=" + this.data.keyword
      })
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
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    if (options.selectid && options.city) {
      this.setData({
        selectid: options.selectid,
        city: options.city
      })
    }

    this.getKeywordList();
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
    // var that = this;
    // wx.request({
    //   url: 'Jpcsc/keyword',
    //   data: {

    //   },
    //   success: function (res) {
    //     that.data.keywordList = res.data.data;
    //     that.changeKeywords();
    //   }
    // })
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
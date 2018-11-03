// pages/qzh/index.js
var util = require('../../utils/util.js');
var isclick = false;
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    hideShopPopup: true,
    hidePaperCrane: true,
  },

  dataCode: function (data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatTime2(newDate);
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    // var that = this;
    // wx.getSystemInfo({
    //   success: function(res) {
    //     var qzh_width = Math.floor((res.windowWidth - 20) / 4);
    //     app.globalData.qzh_width = qzh_width;
    //     that.getQzhList();
    //   }
    // })
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
    if (app.globalData.qzh_width) {
      this.getQzhList();
    }
    // var qzh = new Array();
    // for (var i = 0; i < 12; i++) {
    //   var aaa = {}
    //   aaa.top = Math.round(Math.random() * 900);
    //   aaa.left = Math.round(Math.random() * 340);
    //   aaa.jd = Math.round(Math.random() * 20) - 10;
    //   aaa.img = "/images/1_blue.png";
    //   qzh.push(aaa);
    // }
    // this.setData({
    //   qzh: qzh
    // })
  },

  getQzhList: function() {
    var that = this;
    var qzh_width = app.globalData.qzh_width;
    var user_id = wx.getStorageSync('user_id');
    wx.showLoading();
    wx.request({
      url: app.globalData.subDomain + '/paper_crane_list',
      data: {
        user_id: user_id
      },
      success: (res) => {
        wx.hideLoading();
        if (res.data.code == 0) {
          var datas = res.data.data
          for (var i = 0; i < datas.length; i++) {
            datas[i].top = (Math.floor(i / 4) * qzh_width) + Math.round(Math.random() * 20);
            datas[i].left = (i % 4 * qzh_width) + Math.round(Math.random() * 20);
          }
          that.setData({
            qzh: datas,
            qzh_width: qzh_width
          });
        }
      }
    })
  },

  openQzh: function(e) {
    var that = this;
    wx.showLoading();
    var id = e.currentTarget.dataset.id;
    wx.request({
      url: app.globalData.subDomain + '/paper_crane',
      data: {
        id: id
      },
      success: (res) => {
        wx.hideLoading();
        if (res.data.code == 0) {
          var datas = res.data.data;
          datas.create_time = that.dataCode(datas.create_time);
          that.setData({
            hidePaperCrane: false,
            craneInfo: datas
          });
        } else {
          that.setData({
            craneInfo: null
          });
        }
      }
    })
  },

  addformID: function (e) {
    var user_id = wx.getStorageSync('user_id');
    app.addForm(e.detail.formId, user_id);
  },

  ffQzh: function() {
    this.setData({
      hideShopPopup: false
    })
  },

  closePopupTap: function() {
    this.setData({
      hideShopPopup: true,
      hidePaperCrane: true
    })
  },

  stopMove: function () {
    return;
  },

  fabuClick: function() {
    this.setData({
      isClick: true
    })
  },

  // 数据提交
  bindSave: function(e) {
    var that = this;
    var user_name = e.detail.value.user_name;
    var remark = e.detail.value.remark;

    if (user_name == "") {
      user_name = "匿名"
    }
    if (remark == "") {
      wx.showModal({
        title: '提示',
        content: '请填写千纸鹤内容',
        showCancel: false
      })
      return
    }
    this.setData({
      hideShopPopup: true
    })
    wx.showLoading();
    var qzhImages = app.globalData.qzhImages;
    var picture = qzhImages[Math.floor(Math.random() * qzhImages.length)];
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/paper_crane_add',
      data: {
        user_id: user_id,
        user_name: user_name,
        remark: remark,
        picture: picture,
      },
      success: function(res) {
        wx.hideLoading();
        if (res.data.code != 0) {
          // 登录错误 
          wx.showModal({
            title: '失败',
            content: res.data.msg,
            showCancel: false
          })
          return;
        }
        // 刷新
        that.getQzhList();
      }
    });
    app.addForm(e.detail.formId, user_id);
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
    var that = this;
    setTimeout(function() {
      that.getQzhList();
    }, 500)
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
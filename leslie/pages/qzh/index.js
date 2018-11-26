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
    currentPic: "",
    is_secret: false,
    userInfo: null
  },

  dataCode: function(data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatTime2(newDate);
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    wx.getSystemInfo({
      success: function(res) {
        var qzh_width = Math.floor((res.windowWidth - 20) / 4);
        app.globalData.qzh_width = qzh_width;
        that.getQzhList();
      }
    });
    if (app.globalData.userInfo) {
      this.data.userInfo = app.globalData.userInfo;
      this.setData({
        userInfo: app.globalData.userInfo
      });
    } else {
      this.getUserInfo();
    }
    this.setData({
      qzhImages: app.globalData.qzhImages
    });
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
    // if (app.globalData.userInfo) {
    //   this.setData({
    //     userInfo: app.globalData.userInfo
    //   });
    // }
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
    wx.showLoading();
    wx.request({
      url: app.globalData.subDomain + '/paper_crane_list',
      data: {},
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
    var userInfo = this.data.userInfo;
    if (userInfo && userInfo.user_type > 3) {
      var that = this;
      wx.showLoading();
      var id = e.currentTarget.dataset.id;
      var user_id = wx.getStorageSync('user_id');
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
            if (datas.is_secret && user_id != datas.user_id) {
              datas.remark = "【私密千纸鹤】";
            }
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
    }
  },

  ffQzh: util.throttle(function() {
    var userInfo = this.data.userInfo;
    if (!userInfo) {
      wx.showModal({
        title: '失败',
        content: '放飞失败，请稍后重试。',
        showCancel: false
      })
    } else if (userInfo && userInfo.user_type > 3) {
      this.setData({
        hideShopPopup: false
      })
    } else {
      var that = this;
      var qzhImages = app.globalData.qzhImages;
      var picture = qzhImages[Math.floor(Math.random() * qzhImages.length)];
      var user_id = wx.getStorageSync('user_id');
      wx.request({
        url: app.globalData.subDomain + '/paper_crane_add',
        data: {
          user_id: user_id,
          user_name: "匿名",
          remark: "❤",
          picture: picture,
          is_secret: 1,
        },
        success: function(res) {
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
          wx.showToast({
            title: '放飞成功',
            icon: 'none',
            duration: 2000
          })
        }
      });
    }
  }),

  closePopupTap: function() {
    this.setData({
      hideShopPopup: true,
      hidePaperCrane: true
    })
  },

  stopMove: function() {
    return;
  },

  fabuClick: util.throttle(function() {
    this.setData({
      isClick: true
    })
  }),

  choose_pic: function(e) {
    var currentPic = e.currentTarget.dataset.id;
    this.data.currentPic = currentPic;
    this.setData({
      currentPic: currentPic
    })
  },

  secretChange: function() {
    var is_secret = !this.data.is_secret;
    this.data.is_secret = is_secret;
    this.setData({
      is_secret: is_secret
    })
  },

  addformID: function(e) {
    var user_id = wx.getStorageSync('user_id');
    app.addForm(e.detail.formId, user_id);
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
    var is_secret = Number(this.data.is_secret);
    var picture = this.data.currentPic;
    if (!picture) {
      picture = qzhImages[Math.floor(Math.random() * qzhImages.length)];
    }
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/paper_crane_add',
      data: {
        user_id: user_id,
        user_name: user_name,
        remark: remark,
        picture: picture,
        is_secret: is_secret,
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
        wx.showToast({
          title: '放飞成功',
          icon: 'none',
          duration: 2000
        })
      }
    });
    app.addForm(e.detail.formId, user_id);
  },

  getUserInfo: function() {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/user_detail',
      data: {
        user_id: user_id
      },
      success: (res) => {
        wx.stopPullDownRefresh();
        if (res.data.code == 0) {
          app.globalData.userInfo = res.data.data;
          that.data.userInfo = app.globalData.userInfo;
          that.setData({
            userInfo: res.data.data
          });
        } else {
          that.setData({
            userInfo: null
          });
        }
      }
    })
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
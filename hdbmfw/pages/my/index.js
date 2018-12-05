const app = getApp()

Page({
  data: {
    balance: 0,
    freeze: 0,
    score: 0,
    score_sign_continuous: 0
  },

  buttonTap1: function(e) {
    var user_id = wx.getStorageSync('user_id');
    app.addForm(e.detail.formId, user_id);

    wx.navigateTo({
      url: "/pages/my-gzt/index"
    })
  },
  buttonTap2: function (e) {
    var user_id = wx.getStorageSync('user_id');
    app.addForm(e.detail.formId, user_id);

    wx.navigateTo({
      url: "/pages/order-list-gzt/index"
    })
  },
  onLoad() {},
  onShow() {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo
      });
    } else {
      this.getUserInfo();
    }
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
        if (res.data.code == 0) {
          app.globalData.userInfo = res.data.data;
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
  onGotUserInfo: function(e) {
    var userInfo = e.detail.userInfo;
    userInfo.user_name = userInfo.nickName;
    userInfo.avatar = userInfo.avatarUrl;
    userInfo.sex = userInfo.gender;
    this.setData({
      userInfo: userInfo
    });
    // app.globalData.userInfo.user_name = userInfo.user_name;
    // app.globalData.userInfo.avatar = userInfo.avatar;
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/bindUser',
      data: {
        user_name: userInfo.nickName,
        avatar: userInfo.avatarUrl,
        sex: userInfo.gender,
        user_id: user_id
      },
      success: function(res) {
        if (res.data.code == 0) {
          wx.showToast({
            title: '绑定成功',
            icon: 'success',
            duration: 2000
          })
          that.getUserInfo();
        } else {
          wx.showModal({
            title: '提示',
            content: '绑定失败',
            showCancel: false
          })
        }
      }
    })
  },
  aboutUs: function() {
    wx.showModal({
      title: '关于我们',
      content: app.globalData.shareProfile,
      showCancel: false
    })
  },
  getPhoneNumber: function(e) {
    if (!e.detail.errMsg || e.detail.errMsg != "getPhoneNumber:ok") {
      wx.showModal({
        title: '提示',
        content: '无法获取手机号码',
        showCancel: false
      })
      return;
    }
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/bindMobile',
      data: {
        encryptedData: e.detail.encryptedData,
        iv: e.detail.iv,
        errMsg: e.detail.errMsg,
        user_id: user_id
      },
      success: function(res) {
        if (res.data.code == 0) {
          wx.showToast({
            title: '绑定成功',
            icon: 'success',
            duration: 2000
          })
          that.getUserInfo();
        } else {
          wx.showModal({
            title: '提示',
            content: res.data.message,
            showCancel: false
          })
        }
      }
    })
  },
  // getUserApiInfo: function () {
  //   var that = this;
  //   wx.request({
  //     url: app.globalData.subDomain + '/user_detail',
  //     data: {
  //     },
  //     success: function (res) {
  //       if (res.data.code == 0) {
  //         that.setData({
  //           apiUserInfoMap: res.data.data,
  //           userMobile: res.data.data.base.mobile
  //         });
  //       }
  //     }
  //   })

  // },
  getUserAmount: function() {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/user_amount',
      data: {},
      success: function(res) {
        if (res.data.code == 0) {
          that.setData({
            balance: res.data.data.balance,
            freeze: res.data.data.freeze,
            score: res.data.data.score
          });
        }
      }
    })

  },
  checkScoreSign: function() {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/score_today_signed',
      data: {},
      success: function(res) {
        if (res.data.code == 0) {
          that.setData({
            score_sign_continuous: res.data.data.continuous
          });
        }
      }
    })
  },
  scoresign: function() {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/score_sign',
      data: {},
      success: function(res) {
        if (res.data.code == 0) {
          that.getUserAmount();
          that.checkScoreSign();
        } else {
          wx.showModal({
            title: '错误',
            content: res.data.msg,
            showCancel: false
          })
        }
      }
    })
  },
  recharge: function() {
    wx.navigateTo({
      url: "/pages/recharge/index"
    })
  },
  withdraw: function() {
    wx.navigateTo({
      url: "/pages/withdraw/index"
    })
  },
  toInformation: function(e) {
    var that = this;
    wx.navigateTo({
      url: '/pages/my-information/index',
    })
  }
})
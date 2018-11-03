//app.js
// 引入SDK核心类
var QQMapWX = require('utils/qqmap-wx-jssdk.js');
// 实例化API核心类
var qqmapsdk = new QQMapWX({
  key: 'XRWBZ-H7JLS-H37O7-6S45H-SEJRK-FJB7R' // 必填
});
App({
  onLaunch: function() {
    this.upData();
    var that = this;
    //  获取商城名称
    wx.setStorageSync('mallName', "Leslie大百科");
    var user_id = wx.getStorageSync('user_id');
    if (!user_id) {
      this.login();
    }
  },
  login: function() {
    var that = this;
    wx.login({
      success: function(res) {
        wx.request({
          url: that.globalData.subDomain + '/user_info',
          data: {
            code: res.code
          },
          success: function(res) {
            if (res.data.code != 0) {
              // 登录错误
              wx.hideLoading();
              wx.showModal({
                title: '提示',
                content: '无法登录，请重试',
                showCancel: false
              })
              return;
            } else {
              that.globalData.userInfo = res.data.data;
              that.globalData.uid = res.data.data.user_id;
              wx.setStorageSync('kefu', res.data.kefu);
              wx.setStorageSync('user_id', res.data.data.user_id);
            }
          }
        })
      }
    })
  },
  upData: function() {
    // 获取小程序更新机制兼容
    if (wx.canIUse('getUpdateManager')) {
      const updateManager = wx.getUpdateManager()
      updateManager.onCheckForUpdate(function(res) {
        // 请求完新版本信息的回调
        if (res.hasUpdate) {
          updateManager.onUpdateReady(function() {
            wx.showModal({
              title: '更新提示',
              content: '新版本已经准备好，是否重启应用？',
              success: function(res) {
                if (res.confirm) {
                  // 新的版本已经下载好，调用 applyUpdate 应用新版本并重启
                  updateManager.applyUpdate()
                }
              }
            })
          })
          updateManager.onUpdateFailed(function() {
            // 新的版本下载失败
            wx.showModal({
              title: '已经有新版本了哟~',
              content: '新版本已经上线啦~，请您删除当前小程序，重新搜索打开哟~',
            })
          })
        }
      })
    } else {
      // 如果希望用户在最新版本的客户端上体验您的小程序，可以这样子提示
      wx.showModal({
        title: '提示',
        content: '当前微信版本过低，无法使用该功能，请升级到最新微信版本后重试。'
      })
    }
  },
  addForm: function(formId, userId) {
    var that = this;
    wx.request({
      url: that.globalData.subDomain + '/add_form',
      data: {
        form_id: formId,
        user_id: userId
      },
      success: function(res) {
      }
    })
  },
  sendTempleMsg: function(orderId, trigger, template_id, form_id, page, postJsonString) {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/template-msg/put',
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        type: 0,
        module: 'order',
        business_id: orderId,
        trigger: trigger,
        template_id: template_id,
        form_id: form_id,
        url: page,
        postJsonString: postJsonString
      },
      success: (res) => {
        //console.log('*********************');
        //console.log(res.data);
        //console.log('*********************');
      }
    })
  },
  globalData: {
    qzhImages: ["1_blue.png", "1_green.png", "1_mura.png", "1_orange.png", "1_qing.png", "1_red.png", "2_blue.png", "2_green.png", "2_mura.png", "2_orange.png", "2_qing.png", "2_red.png", "qzh1.png", "qzh10.png", "qzh11.png", "qzh12.png", "qzh13.png", "qzh14.png", "qzh15.png", "qzh16.png", "qzh2.png", "qzh3.png", "qzh4.png", "qzh5.png", "qzh6.png", "qzh7.png", "qzh8.png", "qzh9.png"],
    qzh_width: 0,
    userInfo: null,
    uid: 0,
    subDomain: "https://www.lanrengj.com" + "/wxapi/leslie",
    version: "1.0",
    shareProfile: '风继续吹 不忍远离'
  }
})
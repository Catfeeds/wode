//app.js
// 引入SDK核心类
var QQMapWX = require('utils/qqmap-wx-jssdk.js');
// 实例化API核心类
var qqmapsdk = new QQMapWX({
  key: 'XRWBZ-H7JLS-H37O7-6S45H-SEJRK-FJB7R' // 必填
});
App({
  onLaunch: function() {
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
    userInfo: null,
    uid: 0,
    subDomain: "https://www.lanrengj.com" + "/wxapi/leslie",
    version: "1.0",
    shareProfile: '风继续吹 不忍远离'
  }
})
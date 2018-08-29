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
    wx.setStorageSync('mallName', "黄岛便民服务");
    wx.checkSession({
      success: function() {
        //session_key 未过期，并且在本生命周期一直有效
        var user_id = wx.getStorageSync('user_id');
        if (!user_id) {
          that.login();
        }
      },
      fail: function() {
        // session_key 已经失效，需要重新执行登录流程
        that.login(); //重新登录
      }
    })
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
    subDomain: "https://www.lanrengj.com" + "/wxapi/hdbm",
    version: "1.0",
    shareProfile: '一款黄岛本地便民服务小工具，提供附近便利店查询，闲置物品信息发布等服务。'
    // 一款最新的逛街神器！还在为网购漫长的等待烦恼吗？还在担心网购无法预知的大小色差和材质吗？你想买的东西，说不定就藏在你身边的小店里哟~ 快来一起发现吧！
    // 发现你身边的店铺，你身边的店里说不定藏着你喜欢的东西哟~
  }
  // 根据自己需要修改下单时候的模板消息内容设置，可增加关闭订单、收货时候模板消息提醒
})
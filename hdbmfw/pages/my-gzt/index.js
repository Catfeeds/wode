const app = getApp()

Page({
  data: {
    balance: 0,
    freeze: 0,
    score: 0,
    score_sign_continuous: 0
  },
  onLoad() {
  },
  onShow() {
    if (app.globalData.userInfo){
      this.setData({
        userInfo: app.globalData.userInfo
      });
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
        } else{
          that.setData({
            userInfo: null
          });
        }
      }
    })
  },
  
})
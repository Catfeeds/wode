const app = getApp()

Page({
  data: {
    tabList: [{
        icon: '../../images/my/fukuan.png',
        num: 0,
        text: '今日订单数',
        url: '/pages/search-orders/index?add_time=today'
      },
      {
        icon: '../../images/my/shouhuo.png',
        num: 0,
        text: '今日新用户',
        url: '/pages/search-users/index?reg_time=today'
      },
      {
        icon: '../../images/my/wancheng.png',
        num: 0,
        text: '今日访问用户',
        url: '/pages/search-users/index?last_login=today'
      },
      {
        icon: '../../images/my/wancheng.png',
        num: 0,
        text: '昨日订单数',
        url: '/pages/search-orders/index?add_time=yesterday'
      },
      {
        icon: '../../images/my/wancheng.png',
        num: 0,
        text: '昨日新用户',
        url: '/pages/search-users/index?reg_time=yesterday'
      },
      {
        icon: '../../images/my/wancheng.png',
        num: 0,
        text: '总用户',
        url: '/pages/search-users/index'
      },

    ],
  },

  buttonTap1: function(e) {
    var user_id = wx.getStorageSync('user_id');
    app.addForm(e.detail.formId, user_id);

    wx.navigateTo({
      url: "/pages/order-list-gzt/index"
    })
  },
  buttonTap2: function(e) {
    var user_id = wx.getStorageSync('user_id');
    app.addForm(e.detail.formId, user_id);

    wx.navigateTo({
      url: "/pages/my-users-gzt/index"
    })
  },
  buttonTap3: function(e) {
    var user_id = wx.getStorageSync('user_id');
    app.addForm(e.detail.formId, user_id);

    wx.navigateTo({
      url: "/pages/my-users-ckgzt/index"
    })
  },
  onLoad() {},
  onShow() {
    var that = this;
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo
      });
    }
    wx.request({
      url: app.globalData.subDomain + '/shuju',
      method: 'GET',
      data: {},
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        var datas = res.data.data
        wx.hideLoading();
        if (res.data.code == 0) {
          that.data.tabList[0].num = datas.jinridingdanshu;
          that.data.tabList[1].num = datas.jinrixyh;
          that.data.tabList[2].num = datas.jinrifangke;
          that.data.tabList[3].num = datas.zuoridingdanshu;
          that.data.tabList[4].num = datas.zuorixyh;
          that.data.tabList[5].num = datas.zongfangke;
          that.setData({
            tabList: that.data.tabList
          })
        }
      }
    })
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

})
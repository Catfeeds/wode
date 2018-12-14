var app = getApp()
Page({
  data: {
    currentTab: 0,
    joinData: '',
    createData: '',
    groupData: ''
  },
  onShow: function() {
    var that = this;
    that.updateData();
  },
  updateData: function() {
    var that = this;
    wx.showLoading({
      title: '加载中...',
    })
    var user_id = wx.getStorageSync('user_id');
    wx.request({ //请求我参加的活动列表
      url: app.globalData.subDomain + '/myCreate',
      data: {
        user_id: user_id,
      },
      success: function(res) {
        wx.hideLoading();
        that.setData({
          joinData: res.data.data.ret1,
          createData: res.data.data.ret2,
          groupData: res.data.data.ret3
        })
      }
    });
  },
  swichNav: function(e) {
    var that = this;
    that.setData({
      currentTab: e.target.dataset.current,
    })
  },
  creat: function() {
    var that = this;
    wx.navigateTo({
      url: '../create/create'
    })
  },
  gotoEnroll: function(e) {
    var that = this;
    wx.navigateTo({
      url: '../enroll/enroll?taskid=' + e.currentTarget.dataset.taskid
    })
  }
})
//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    shuipiaos: []
  },
  onLoad: function() {},
  onShow: function() {
    this.getMyShuipiaos();
  },
  getMyShuipiaos: function() {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/user_water_list',
      data: {
        user_id: user_id
      },
      success: function(res) {
        if (res.data.code == 0) {
          var shuipiaos = res.data.data;
          if (shuipiaos.length > 0) {
            that.setData({
              shuipiaos: shuipiaos
            });
          }
        }
      }
    })
  },
  allSelect: function () {
    var list = this.data.shuipiaos;
    var allSelect = false;
    for (var i = 0; i < list.length; i++) {
      var curItem = list[i];
      if (curItem.active) {
        allSelect = true;
      } else {
        allSelect = false;
        break;
      }
    }
    return allSelect;
  },
  noSelect: function () {
    var list = this.data.shuipiaos;
    var noSelect = 0;
    for (var i = 0; i < list.length; i++) {
      var curItem = list[i];
      if (!curItem.active) {
        noSelect++;
      }
    }
    if (noSelect == list.length) {
      return true;
    } else {
      return false;
    }
  },
  toDetailsTap: function (e) {
    wx.navigateTo({
      url: "/pages/goods-details/index?id=" + e.currentTarget.dataset.id
    })
  },
})
const app = getApp()
var util = require('../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    statusType: ["新用户", "新访问", "绑定"],
    statusKey: ["1", "2", "3"],
    currentType: 0,
    currentStatu: "1",
  },
  statusTap: function(e) {
    var that = this
    var curType = e.currentTarget.dataset.index;
    var curStatu = e.currentTarget.dataset.statu;
    this.data.currentType = curType
    this.data.currentStatu = curStatu
    this.setData({
      currentType: curType,
      currentStatu: curStatu
    });
  },
  dataCode: function(data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatTime(newDate);
  },

  toUserOrder: function(e) {
    var user_id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: "/pages/order-list-user/index?user_id=" + user_id
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.getShenheList()
  },
  //审核列表
  getShenheList: function() {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/ck_yhlb',
      data: {},
      success: function(res) {
        if (res.data.code == 0) {
          var user1 = res.data.data.user1;
          for (var i = 0; i < user1.length; i++) {
            user1[i].reg_time = that.dataCode(user1[i].reg_time);
          }
          var user2 = res.data.data.user2;
          for (var i = 0; i < user2.length; i++) {
            user2[i].last_login = that.dataCode(user2[i].last_login);
          }
          that.setData({
            user1: user1,
            user2: user2,
            user3: res.data.data.user3
          })
        }
      }
    })
  },

  toSetTap: function(e) {
    var that = this;
    var user_id = e.currentTarget.dataset.id;

    wx.showActionSheet({
      itemList: ['设为管理员', '设为会员', '删除'],
      success: function(res) {
        switch (res.tapIndex) {
          case 0:
            that.swgl(user_id);
            break;
          case 1:
            that.byh(user_id);
            break;
          case 2:
            that.hyh(user_id);
            break;
          default:
            break;
        }
      },
      fail: function(res) {}
    })
  },

  //设为会员
  byh: function(user_id) {
    var that = this;
    var user_id = user_id;
    wx.request({
      url: app.globalData.subDomain + '/byh',
      data: {
        user_id: user_id
      },
      success: function(res) {
        wx.showToast({
          title: '设为会员成功',
          icon: 'success',
          duration: 2000
        })
        that.getShenheList()
      }
    })
  },

  //删除
  hyh: function(user_id) {
    var that = this;
    var user_id = user_id;
    wx.request({
      url: app.globalData.subDomain + '/hyh',
      data: {
        user_id: user_id
      },
      success: function(res) {
        wx.showToast({
          title: '删除成功',
          icon: 'success',
          duration: 2000
        })
        that.getShenheList()
      }
    })
  },

  //设为管理
  swgl: function(user_id) {
    var that = this;
    var user_id = user_id;
    wx.request({
      url: app.globalData.subDomain + '/swgl',
      data: {
        user_id: user_id
      },
      success: function(res) {
        wx.showToast({
          title: '设为管理成功',
          icon: 'success',
          duration: 2000
        })
        that.getShenheList()
      }
    })
  },
  //取消管理
  qxgl: function(e) {
    var that = this;
    var user_id = e.currentTarget.dataset.id;
    wx.request({
      url: app.globalData.subDomain + '/qxgl',
      data: {
        user_id: user_id
      },
      success: function(res) {
        wx.showToast({
          title: '取消管理成功',
          icon: 'success',
          duration: 2000
        })
        that.getShenheList()
      }
    })
  },
  tocallphone: function(e) {
    var phone = e.currentTarget.dataset.phone
    wx.makePhoneCall({
      phoneNumber: phone
    })
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

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

})
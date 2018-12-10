const app = getApp()
var util = require('../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {

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
    if (options.reg_time) {
      this.getShenheList(options.reg_time, "");
    } else if (options.last_login) {
      this.getShenheList("", options.last_login);
    } else {
      this.getShenheList("", "");
    }
  },
  //列表
  getShenheList: function(reg_time, last_login) {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/user_search',
      data: {
        reg_time,
        last_login
      },
      success: function(res) {
        if (res.data.code == 0) {
          var users = res.data.data;
          for (var i = 0; i < users.length; i++) {
            users[i].last_login = that.dataCode(users[i].last_login);
          }
          that.setData({
            users: users,
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
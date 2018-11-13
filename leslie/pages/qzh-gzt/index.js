const app = getApp()
var util = require('../../utils/util.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    hideShopPopup: true,
  },
  dataCode: function(data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatTime(newDate);
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
      url: app.globalData.subDomain + '/paper_crane_list',
      data: {},
      success: function(res) {
        if (res.data.code == 0) {
          var datas = res.data.data;
          for (var i = 0; i < datas.length; i++) {
            datas[i].create_time = that.dataCode(datas[i].create_time);
          }
          that.setData({
            datas: datas,
          })
        }
      }
    })
  },
  //发消息
  sendMsgTap: function (e) {
    var user_id = e.currentTarget.dataset.userid;
    wx.navigateTo({
      url: "../send-msg/show?user_id=" + user_id
    })
  },
  //修改
  openPopupTap: function(e) {
    var id = e.currentTarget.dataset.id;
    var name = e.currentTarget.dataset.name;
    var remark = e.currentTarget.dataset.remark;
    this.setData({
      id: id,
      name: name,
      remark: remark,
      hideShopPopup: false
    })
  },

  closePopupTap: function() {
    this.setData({
      hideShopPopup: true,
      hidePaperCrane: true
    })
  },


  xgClick: function () {
    this.setData({
      isClick: true
    })
  },

  // 数据提交
  bindSave: function (e) {
    var that = this;
    var id = e.detail.value.id;
    var remark = e.detail.value.remark;

    this.setData({
      hideShopPopup: true
    })
    wx.request({
      url: app.globalData.subDomain + '/paper_crane_update',
      data: {
        id: id,
        remark: remark,
      },
      success: function (res) {
        wx.hideLoading();
        if (res.data.code != 0) {
          // 登录错误 
          wx.showModal({
            title: '失败',
            content: res.data.msg,
            showCancel: false
          })
          return;
        }
        // 刷新
        that.getShenheList();
      }
    });
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
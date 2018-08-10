var commonCityData = require('../../utils/city.js')
//获取应用实例
var app = getApp()
Page({
  data: {},
  bindCancel: function() {
    wx.navigateBack({})
  },
  bindSave: function(e) {
    var that = this;
    var consignee = e.detail.value.consignee;
    var address = e.detail.value.address;
    var mobile = e.detail.value.mobile;

    if (consignee == "") {
      wx.showModal({
        title: '提示',
        content: '请填写联系人姓名',
        showCancel: false
      })
      return
    }
    if (mobile == "") {
      wx.showModal({
        title: '提示',
        content: '请填写手机号码',
        showCancel: false
      })
      return
    }
    if (address == "") {
      wx.showModal({
        title: '提示',
        content: '请填写详细地址',
        showCancel: false
      })
      return
    }
    var apiAddoRuPDATE = "add";
    var address_id = that.data.id;
    if (address_id) {
      apiAddoRuPDATE = "update";
    } else {
      address_id = 0;
    }
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/shipping_address_add',
      data: {
        address_id: address_id,
        user_id: user_id,
        consignee: consignee,
        address: address,
        mobile: mobile,
        is_default: "1"
      },
      success: function(res) {
        if (res.data.code != 0) {
          // 登录错误 
          wx.hideLoading();
          wx.showModal({
            title: '失败',
            content: res.data.msg,
            showCancel: false
          })
          return;
        }
        // 跳转到结算页面
        wx.navigateBack({})
      }
    })
  },
  onLoad: function(e) {
    var that = this;
    var id = e.id;
    if (id) {
      // 初始化原数据
      wx.showLoading();
      wx.request({
        url: app.globalData.subDomain + '/shipping_address_detail',
        data: {
          address_id: id
        },
        success: function(res) {
          wx.hideLoading();
          if (res.data.code == 0) {
            that.setData({
              id: id,
              addressData: res.data.data
            });
            return;
          } else {
            wx.showModal({
              title: '提示',
              content: '无法获取地址数据',
              showCancel: false
            })
          }
        }
      })
    } else {
    }
  },
  deleteAddress: function(e) {
    var that = this;
    var id = e.currentTarget.dataset.id;
    wx.showModal({
      title: '提示',
      content: '确定要删除该收货地址吗？',
      success: function(res) {
        if (res.confirm) {
          wx.request({
            url: app.globalData.subDomain + '/shipping_address_delete',
            data: {
              address_id: id
            },
            success: (res) => {
              wx.navigateBack({})
            }
          })
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  }
})
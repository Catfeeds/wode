//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    addressList: []
  },

  selectTap: function (e) {
    var id = e.currentTarget.dataset.id;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/shipping_address_setdefault',
      data: {
        user_id: user_id,
        address_id: id,
        is_default: '1'
      },
      success: (res) => {
        wx.navigateBack({})
      }
    })
  },

  addAddess: function () {
    wx.navigateTo({
      url: "/pages/address-add/index"
    })
  },

  editAddess: function (e) {
    wx.navigateTo({
      url: "/pages/address-add/index?id=" + e.currentTarget.dataset.id
    })
  },

  onLoad: function () {
  },
  onShow: function () {
    this.initShippingAddress();
  },
  initShippingAddress: function () {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/shipping_address_list',
      data: {
        user_id: user_id
      },
      success: (res) => {
        if (res.data.code == 0) {
          that.setData({
            addressList: res.data.data
          });
        } else if (res.data.code == 700) {
          that.setData({
            addressList: null
          });
        }
      }
    })
  },
  // 获取wx收货地址
  getWxAddress: function () {
    var that = this;
    wx.getSetting({
      success: (res) => {
        if (res.authSetting["scope.address"] == undefined || res.authSetting["scope.address"]) {
          wx.chooseAddress({
            success(res) {
              that.requestWXAddress(res);
            }
          })
          return;
        }
        if (!res.authSetting["scope.address"]) {
          wx.openSetting({
            success: (res) => {
              if (res.authSetting["scope.address"]) {
                wx.chooseAddress({
                  success(res) {
                    that.setData({
                      addressInfo: res
                    })
                  }
                })
              }
            }
          })
        }
      }
    })
  },
  requestWXAddress: function (res) {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    var consignee = res.userName;
    var address = res.detailInfo;
    var mobile = res.telNumber;
    wx.request({
      url: app.globalData.subDomain + '/shipping_address_add',
      data: {
        address_id: 0,
        user_id: user_id,
        consignee: consignee,
        address: address,
        mobile: mobile,
        is_default: "0"
      },
      success: function (res) {
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
        wx.showToast({
          title: '发布成功',
          icon: 'success',
          mask: false
        })
        setTimeout(function () {
          that.initShippingAddress();
        }, 1500)
      }
    })
  },

})

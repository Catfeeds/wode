var util = require('../../utils/util.js');
var app = getApp()
Page({
  data: {
    // statusType: ["全部", "待发货", "待收货", "已完成"],
    // statusKey: ["0", "1", "2", "3"],
    // currentType: 0,
    // currentStatu: "0",
    tabClass: ["", "", "", ""]
  },
  // statusTap: function(e) {
  //   var curType = e.currentTarget.dataset.index;
  //   var curStatu = e.currentTarget.dataset.statu;
  //   this.data.currentType = curType
  //   this.data.currentStatu = curStatu
  //   this.setData({
  //     currentType: curType,
  //     currentStatu: curStatu
  //   });
  //   this.onShow();
  // },
  dataCode: function(data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatTime(newDate);
  },
  orderDetail: function(e) {
    var orderId = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: "/pages/order-details/index?id=" + orderId
    })
  },
  onLoad: function(options) {
    console.log(options)
    // 获取订单列表
    wx.showLoading();
    var that = this;
    var postData = {};
    postData.status = 0;
    postData.user_id = options.user_id;
    wx.request({
      url: app.globalData.subDomain + '/order_list_all',
      data: postData,
      success: (res) => {
        wx.hideLoading();
        if (res.data.code == 0) {
          var datas = res.data.data.orderList;
          var datasW = res.data.data.orderWaterList;
          for (var i = 0; i < datas.length; i++) {
            datas[i].add_time = that.dataCode(datas[i].add_time);
          }
          for (var i = 0; i < datasW.length; i++) {
            datasW[i].add_time = that.dataCode(datasW[i].add_time);
          }
          that.setData({
            orderWaterList: datasW,
            goodsWaterMap: res.data.data.goodsWaterMap,
            orderList: datas,
            goodsMap: res.data.data.goodsMap
          });
        } else {
          this.setData({
            orderWaterList: null,
            goodsWaterMap: {},
            orderList: null,
            goodsMap: {}
          });
        }
      }
    })
    var user_id = options.user_id;
    wx.request({
      url: app.globalData.subDomain + '/user_water_list',
      data: {
        user_id: user_id
      },
      success: function (res) {
        if (res.data.code == 0) {
          var shuipiaos = res.data.data;
          var us = res.data.us;
          if (shuipiaos.length > 0) {
            that.setData({
              shuipiaos: shuipiaos,
              us: us
            });
          }
        }
      }
    })
    // 生命周期函数--监听页面加载
    // console.log(options.order_status);
    // if (options.currentType && options.currentType.length > 0) {
    //   this.setData({
    //     order_status: options.order_status,
    //     currentType: options.currentType,
    //     currentStatu: options.order_status
    //   })
    // }else if(options.order_status) {
    //   this.setData({
    //     order_status: options.order_status,
    //     currentType: options.order_status,
    //     currentStatu: options.order_status
    //   })
    // }
  }, 
  onReady: function() {
    // 生命周期函数--监听页面初次渲染完成

  },
  onShow: function () {
    
  },
  onHide: function() {
    // 生命周期函数--监听页面隐藏

  },
  onUnload: function() {
    // 生命周期函数--监听页面卸载

  },
  onPullDownRefresh: function() {
    // 页面相关事件处理函数--监听用户下拉动作

  },
  onReachBottom: function() {
    // 页面上拉触底事件的处理函数

  },
  makePhoneCall: function(e) {
    var phoneNumber = wx.getStorageSync('kefu');
    wx.makePhoneCall({
      phoneNumber: phoneNumber,
    })
  },

})
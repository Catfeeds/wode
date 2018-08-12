//index.js
//获取应用实例
var app = getApp()
var util = require('../../utils/util.js');

Page({
  data: {
    goodsList: [],
    isNeedLogistics: 0, // 是否需要物流信息
    allGoodsPrice: 0,
    yunPrice: 0,
    allGoodsAndYunPrice: 0,
    goodsJsonStr: "",
    orderType: "", //订单类型，购物车下单或立即支付下单，默认是购物车，
    dateValue: '',
    dateStart: '',
    dateEnd: '',
  },
  onShow: function() {
    var newDate = new Date();
    var newDateStart = new Date();
    var newDateEnd = new Date();
    newDateEnd.setDate(newDate.getDate() + 2);
    this.setData({
      dateValue: util.formatDate2(newDate),
      dateStart: util.formatDate2(newDateStart),
      dateEnd: util.formatDate2(newDateEnd)
    })

    var that = this;
    var shopList = [];
    //立即购买下单
    if ("buyNow" == that.data.orderType) {
      var buyNowInfoMem = wx.getStorageSync('buyNowInfo');
      if (buyNowInfoMem && buyNowInfoMem.shopList) {
        shopList = buyNowInfoMem.shopList
      }
    } else if ("jiaoshuiNow" == that.data.orderType) {
      var buyNowInfoMem = wx.getStorageSync('buyNowInfo');
      if (buyNowInfoMem && buyNowInfoMem.shopList) {
        shopList = buyNowInfoMem.shopList
      }
    } else {
      //购物车下单
      var shopCarInfoMem = wx.getStorageSync('shopCarInfo');
      if (shopCarInfoMem && shopCarInfoMem.shopList) {
        // shopList = shopCarInfoMem.shopList
        shopList = shopCarInfoMem.shopList.filter(entity => {
          return entity.active;
        });
      }
    }
    var total = 0;
    for (var i = 0; i < shopList.length; i++) {
      total += parseFloat(shopList[i].goods_price) * shopList[i].goods_number;
    }
    total = parseFloat(total.toFixed(2));
    that.data.goodsList = shopList;
    that.data.allGoodsPrice = total;
    that.setData({
      goodsList: shopList,
      allGoodsPrice: total,
    });
    that.initShippingAddress();
  },

  onLoad: function(e) {
    var that = this;
    //显示收货地址标识
    that.setData({
      isNeedLogistics: 1,
      orderType: e.orderType
    });
  },

  datePickerBindchange: function(e) {
    this.setData({
      dateValue: e.detail.value
    })
  },

  createOrder: function(e) {
    wx.showLoading();
    var that = this;
    var remark = ""; // 备注信息
    var first_num = 1;
    if (e) {
      remark = e.detail.value.remark; // 备注信息
      first_num = e.detail.value.first_num;
    }
    var goodsList = that.data.goodsList;
    var order_amount = that.data.allGoodsPrice;
    var best_time = that.data.dateValue;
    //var inviter_id = wx.getStorageSync('inviter_id');
    var user_id = wx.getStorageSync('user_id');
    var postData = {
      goodsList: goodsList,
      order_amount: order_amount,
      first_num: first_num,
      best_time: best_time,
      remark: remark,
      //inviter_id: inviter_id,
      user_id: user_id
    };
    if (that.data.isNeedLogistics > 0) {
      if (!that.data.curAddressData) {
        wx.hideLoading();
        wx.showModal({
          title: '错误',
          content: '请先设置您的收货地址！',
          showCancel: false
        })
        return;
      }
      postData.address = that.data.curAddressData.address;
      postData.consignee = that.data.curAddressData.consignee;
      postData.mobile = that.data.curAddressData.mobile;
    }
    var req ="/order_create";
    if ("jiaoshuiNow" == that.data.orderType) {
      req = "/order_water_create";
    }
    wx.request({
      url: app.globalData.subDomain + req,
      method: 'POST',
      header: {
        'Accept': 'application/json'
      },
      data: postData, // 设置请求的 参数
      success: (res) => {
        wx.hideLoading();
        if (res.data.code != 0) {
          wx.showModal({
            title: '错误',
            content: res.data.msg,
            showCancel: false
          })
          return;
        }

        if (e && "buyNow" != that.data.orderType) {
          // 清空购物车数据
          wx.removeStorageSync('shopCarInfo');
        }

        // // 配置模板消息推送
        // var postJsonString = {};
        // postJsonString.keyword1 = { value: res.data.data.dateAdd, color: '#173177' }
        // postJsonString.keyword2 = { value: res.data.data.amountReal + '元', color: '#173177' }
        // postJsonString.keyword3 = { value: res.data.data.orderNumber, color: '#173177' }
        // postJsonString.keyword4 = { value: '订单已关闭', color: '#173177' }
        // postJsonString.keyword5 = { value: '您可以重新下单，请在30分钟内完成支付', color:'#173177'}
        // app.sendTempleMsg(res.data.data.id, -1,
        //   'uJQMNVoVnpjRm18Yc6HSchn_aIFfpBn1CZRntI685zY', e.detail.formId,
        //   'pages/index/index', JSON.stringify(postJsonString));
        // postJsonString = {};
        // postJsonString.keyword1 = { value: '您的订单已发货，请注意查收', color: '#173177' }
        // postJsonString.keyword2 = { value: res.data.data.orderNumber, color: '#173177' }
        // postJsonString.keyword3 = { value: res.data.data.dateAdd, color: '#173177' }
        // app.sendTempleMsg(res.data.data.id, 2,
        //   'GeZutJFGEWzavh69savy_KgtfGj4lHqlP7Zi1w8AOwo', e.detail.formId,
        //   'pages/order-details/index?id=' + res.data.data.id, JSON.stringify(postJsonString));
        // 下单成功，跳转到订单管理界面
        wx.redirectTo({
          url: "/pages/order-list/index"
        });
      }
    })
  },
  initShippingAddress: function() {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/shipping_address_default',
      data: {
        user_id: user_id,
      },
      success: (res) => {
        if (res.data.code == 0) {
          that.setData({
            curAddressData: res.data.data
          });
        } else {
          that.setData({
            curAddressData: null
          });
        }
      }
    })
  },
  addAddress: function() {
    wx.navigateTo({
      url: "/pages/address-add/index"
    })
  },
  selectAddress: function() {
    wx.navigateTo({
      url: "/pages/select-address/index"
    })
  }
})
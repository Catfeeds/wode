//index.js
//获取应用实例
var app = getApp();
var WxParse = require('../../wxParse/wxParse.js');

Page({
  data: {
    autoplay: true,
    interval: 3000,
    duration: 1000,
    goodsDetail: {},
    swiperCurrent: 0,
    hasMoreSelect: false,
    selectSize: "选择：",
    selectSizePrice: 0,
    shopNum: 0,
    hideShopPopup: true,
    buyNumber: 0,
    buyNumMin: 1,
    buyNumMax: 0,

    canSubmit: false, //  选中规格尺寸时候是否允许加入购物车
    shopCarInfo: {},
    shopType: "addShopCar", //购物类型，加入购物车或立即购买，默认为加入购物车
  },

  //事件处理函数
  swiperchange: function(e) {
    //console.log(e.detail.current)
    this.setData({
      swiperCurrent: e.detail.current
    })
  },
  onLoad: function(e) {
    if (e.inviter_id) {
      var inviter_id = e.inviter_id;
      var user_id = wx.getStorageSync('user_id');
      if (user_id != inviter_id) {
        wx.request({
          url: app.globalData.subDomain + '/up_user_inviter',
          data: {
            inviter_id: inviter_id,
            goods_id: e.id,
            user_id: user_id
          },
          success: function(res) {}
        })
      }
      // app.globalData.inviter_id = e.inviter_id;
      // wx.setStorageSync('inviter_id', e.inviter_id);
      // wx.setStorage({
      //   key: 'inviter_id_' + e.id,
      //   data: e.inviter_id
      // })
    }
    var that = this;
    // 获取购物车数据
    wx.getStorage({
      key: 'shopCarInfo',
      success: function(res) {
        // console.log(res);
        that.setData({
          shopCarInfo: res.data,
          shopNum: res.data.shopNum
        });
      }
    })
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/goods_detail',
      data: {
        id: e.id,
        user_id: user_id
      },
      success: function(res) {
        var selectSizeTemp = "";
        that.data.goodsDetail = res.data.data;
        that.setData({
          goodsDetail: res.data.data,
          selectSizePrice: res.data.data.shop_price,
          buyNumMax: res.data.data.goods_number,
          buyNumber: (res.data.data.goods_number > 0) ? 1 : 0
        });
        WxParse.wxParse('article', 'html', res.data.data.goods_desc, that, 5);
      }
    })
  },
  goShopCar: function() {
    wx.navigateTo({
      url: "/pages/shop-cart/index"
    });
  },
  toAddShopCar: function() {
    this.setData({
      shopType: "addShopCar"
    })
    this.bindGuiGeTap();
  },
  tobuy: function() {
    this.setData({
      shopType: "tobuy"
    });
    this.bindGuiGeTap();
  },
  tojiaoshui: function() {
    this.setData({
      shopType: "tojiaoshui"
    });
    this.bindGuiGeTap();
  },
  /**
   * 规格选择弹出框
   */
  bindGuiGeTap: function() {
    this.setData({
      hideShopPopup: false
    })
  },
  /**
   * 规格选择弹出框隐藏
   */
  closePopupTap: function() {
    this.setData({
      hideShopPopup: true
    })
  },
  numJianTap: function() {
    if (this.data.buyNumber > this.data.buyNumMin) {
      var currentNum = this.data.buyNumber;
      currentNum--;
      this.setData({
        buyNumber: currentNum
      })
    }
  },
  numJiaTap: function() {
    if (this.data.shopType == "tojiaoshui") {
      if (this.data.buyNumber < this.data.goodsDetail.shuipiao) {
        var currentNum = this.data.buyNumber;
        currentNum++;
        this.setData({
          buyNumber: currentNum
        })
      }
    } else {
      if (this.data.buyNumber < this.data.buyNumMax) {
        var currentNum = this.data.buyNumber;
        currentNum++;
        this.setData({
          buyNumber: currentNum
        })
      }
    }

  },
  /**
   * 加入购物车
   */
  addShopCar: function() {
    if (this.data.buyNumber < 1) {
      wx.showModal({
        title: '提示',
        content: '购买数量不能为0！',
        showCancel: false
      })
      return;
    }
    //组建购物车
    var shopCarInfo = this.bulidShopCarInfo();

    this.setData({
      shopCarInfo: shopCarInfo,
      shopNum: shopCarInfo.shopNum
    });

    // 写入本地存储
    wx.setStorage({
      key: "shopCarInfo",
      data: shopCarInfo
    })
    this.closePopupTap();
    wx.showToast({
      title: '加入购物车成功',
      icon: 'success',
      duration: 2000
    })
  },
  /**
   * 立即购买
   */
  buyNow: function() {
    if (this.data.buyNumber < 1) {
      wx.showModal({
        title: '提示',
        content: '购买数量不能为0！',
        showCancel: false
      })
      return;
    }
    //组建立即购买信息
    var buyNowInfo = this.buliduBuyNowInfo();
    // 写入本地存储
    wx.setStorage({
      key: "buyNowInfo",
      data: buyNowInfo
    })
    this.closePopupTap();

    wx.navigateTo({
      url: "/pages/to-pay-order/index?orderType=buyNow"
    })
  },
  /**
   * 立即叫水
   */
  jiaoshuiNow: function() {
    if (this.data.buyNumber < 1) {
      wx.showModal({
        title: '提示',
        content: '叫水数量不能为0！',
        showCancel: false
      })
      return;
    }
    //组建立即购买信息
    var buyNowInfo = this.buliduBuyNowInfo();
    // 写入本地存储
    wx.setStorage({
      key: "buyNowInfo",
      data: buyNowInfo
    })
    this.closePopupTap();

    wx.navigateTo({
      url: "/pages/to-pay-order/index?orderType=jiaoshuiNow"
    })
  },
  /**
   * 组建购物车信息
   */
  bulidShopCarInfo: function() {
    // 加入购物车
    var shopCarMap = {};
    shopCarMap.goods_id = this.data.goodsDetail.goods_id;
    shopCarMap.goods_imgs = this.data.goodsDetail.pic;
    shopCarMap.goods_name = this.data.goodsDetail.goods_name;
    shopCarMap.water_number = this.data.goodsDetail.water_number;
    shopCarMap.goods_price = this.data.selectSizePrice;
    shopCarMap.left = "";
    shopCarMap.active = true;
    shopCarMap.goods_number = this.data.buyNumber;

    var shopCarInfo = this.data.shopCarInfo;
    if (!shopCarInfo.shopNum) {
      shopCarInfo.shopNum = 0;
    }
    if (!shopCarInfo.shopList) {
      shopCarInfo.shopList = [];
    }
    var hasSameGoodsIndex = -1;
    for (var i = 0; i < shopCarInfo.shopList.length; i++) {
      var tmpShopCarMap = shopCarInfo.shopList[i];
      if (tmpShopCarMap.goods_id == shopCarMap.goods_id) {
        hasSameGoodsIndex = i;
        shopCarMap.goods_number = shopCarMap.goods_number + tmpShopCarMap.goods_number;
        break;
      }
    }

    shopCarInfo.shopNum = shopCarInfo.shopNum + this.data.buyNumber;
    if (hasSameGoodsIndex > -1) {
      shopCarInfo.shopList.splice(hasSameGoodsIndex, 1, shopCarMap);
    } else {
      shopCarInfo.shopList.push(shopCarMap);
    }
    return shopCarInfo;
  },
  /**
   * 组建立即购买信息
   */
  buliduBuyNowInfo: function() {
    var shopCarMap = {};
    shopCarMap.goods_id = this.data.goodsDetail.goods_id;
    shopCarMap.goods_imgs = this.data.goodsDetail.pic;
    shopCarMap.goods_name = this.data.goodsDetail.goods_name;
    shopCarMap.water_number = this.data.goodsDetail.water_number;
    shopCarMap.goods_price = this.data.selectSizePrice;
    shopCarMap.left = "";
    shopCarMap.active = true;
    shopCarMap.goods_number = this.data.buyNumber;

    var buyNowInfo = {};
    if (!buyNowInfo.shopNum) {
      buyNowInfo.shopNum = 0;
    }
    if (!buyNowInfo.shopList) {
      buyNowInfo.shopList = [];
    }

    buyNowInfo.shopList.push(shopCarMap);
    return buyNowInfo;
  },
  makePhoneCall: function(e) {
    var phoneNumber = wx.getStorageSync('kefu');
    wx.makePhoneCall({
      phoneNumber: phoneNumber,
    })
  },
  onShareAppMessage: function() {
    var user_id = wx.getStorageSync('user_id');
    return {
      title: this.data.goodsDetail.goods_name,
      path: '/pages/goods-details/index?id=' + this.data.goodsDetail.goods_id + '&inviter_id=' + user_id,
      success: function(res) {
        // 转发成功
      },
      fail: function(res) {
        // 转发失败
      }
    }
  }
})
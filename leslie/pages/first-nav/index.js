//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    indicatorDots: true,
    autoplay: true,
    interval: 3000,
    duration: 1000,
    loadingHidden: false, // loading
    userInfo: {},
    swiperCurrent: 0,
    selectCurrent: 0,
    categories: [],
    activeCategoryId: 0,
    goods: [],
    scrollTop: "0",
    loadingMoreHidden: true,

  },
  //事件处理函数
  swiperchange: function(e) {
    //console.log(e.detail.current)
    this.setData({
      swiperCurrent: e.detail.current
    })
  },
  toDetailsTap: function(e) {
    wx.navigateTo({
      url: "/pages/goods-details/index?id=" + e.currentTarget.dataset.id
    })
  },
  tapBanner: function(e) {
    // wx.navigateTo({
    //   url: "/pages/video-show/index"
    // })
  },
  statusTap: function (e) {
    var id = e.currentTarget.dataset.id;
    var curName = e.currentTarget.dataset.name;
    wx.navigateTo({
      url: "/pages/hudong-list/index?id=" + id + "&curName=" + curName
    })
  },
  bindTypeTap: function(e) {
    this.setData({
      selectCurrent: e.index
    })
  },
  scroll: function(e) {
    //  console.log(e) ;
    var that = this,
      scrollTop = that.data.scrollTop;
    that.setData({
      scrollTop: e.detail.scrollTop
    })
    // console.log('e.detail.scrollTop:'+e.detail.scrollTop) ;
    // console.log('scrollTop:'+scrollTop)
  },
  buttonTap: function (e) {
    var user_id = wx.getStorageSync('user_id');
    app.addForm(e.detail.formId, user_id);

    var keyword = e.detail.value.keyword;
    wx.navigateTo({
      url: "/pages/search/index?keyword=" + keyword
    })
  },
  onLoad: function() {
    var that = this
    wx.setNavigationBarTitle({
      title: wx.getStorageSync('mallName')
    })

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo
      });
    } else {
      this.getUserInfo();
    }

    // wx.request({
    //   url: app.globalData.subDomain + '/banner_list',
    //   data: {
    //     key: 'mallName'
    //   },
    //   success: function(res) {
    //     if (res.data.code == 404) {
    //       wx.showModal({
    //         title: '提示',
    //         content: '请在后台添加 banner 轮播图片',
    //         showCancel: false
    //       })
    //     } else {
    //       that.setData({
    //         banners: res.data.data
    //       });
    //     }
    //   }
    // })
    that.getNotice();
    that.getCategory();
  },


  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
    this.getUserInfo();
  },

  getUserInfo: function() {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/user_detail',
      data: {
        user_id: user_id
      },
      success: (res) => {
        wx.stopPullDownRefresh();
        if (res.data.code == 0) {
          app.globalData.userInfo = res.data.data;
          that.setData({
            userInfo: res.data.data
          });
        } else {
          that.setData({
            userInfo: null
          });
        }
      }
    })
  },
  onShareAppMessage: function() {
    return {
      title: wx.getStorageSync('mallName') + '——' + app.globalData.shareProfile,
      path: '/pages/index/index',
      success: function(res) {
        // 转发成功
      },
      fail: function(res) {
        // 转发失败
      }
    }
  },
  getNotice: function() {
    var that = this;
    wx.request({
      url: app.globalData.subDomain + '/notice_list',
      data: {
        pageSize: 5
      },
      success: function(res) {
        if (res.data.code == 0) {
          that.setData({
            noticeList: res.data.data
          });
        }
      }
    })
  },
  getCategory: function() {
    var that = this;
    // 获取分类
    wx.request({
      url: app.globalData.subDomain + '/hudong_list',
      method: 'GET',
      data: {},
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        if (res.data.code == 0) {
          that.setData({
            statusType: res.data.data.result1,
            statusType2: res.data.data.result2
          });
        }
      }
    })
  },
  toXuanyaoTap: function() {
    wx.navigateTo({
      url: '/pages/xy-xxlb/index'
    })
  },
  toToupiaoTap: function() {
    wx.showToast({
      title: '敬请期待',
      icon: 'none',
      duration: 2000
    })
    // wx.navigateTo({
    //   url: '/pages/vote/index/index'
    // })
  },
  toYouxiTap: function() {
    wx.showToast({
      title: '敬请期待',
      icon: 'none',
      duration: 2000
    })
    // wx.navigateTo({
    //   url: '/pages/Game//index'
    // })
  },
  toChoujiangTap: function() {
    wx.navigateTo({
      url: '/pages/Game/choujiang/index'
    })
  },
  toZhoubianTap: function() {
    wx.navigateTo({
      url: '/pages/es-xxlb/index'
    })
  },
  toZutuanTap: function() {
    wx.showToast({
      title: '敬请期待',
      icon: 'none',
      duration: 2000
    })
    // wx.navigateTo({
    //   url: '/pages/link/index/index'
    // })
  },
})
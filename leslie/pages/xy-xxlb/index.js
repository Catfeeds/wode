var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pages: 1,
    isMoredata: true, //是否请求到数据
    isHideLoadMore: true, //是否显示加载更多.默认为true
  },

  /**
   * 跳转发布任务页面
   */
  fabuTask: function(e) {
    wx.navigateTo({
      url: "/pages/xy-fbxx/index"
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

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
    var user_id = wx.getStorageSync('user_id');
    this.setData({
      user_id: user_id,
    });
    this.getXxList();
  },

  getXxList: function() {
    var that = this;
    var pages = this.data.pages;
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/esxx_list',
      data: {
        page: pages,
        is_xy: 1,
        user_id: user_id,
      },
      success: (res) => {
        wx.stopPullDownRefresh();
        wx.hideLoading();
        that.setData({
          isHideLoadMore: true
        });

        var esxxList = new Array();
        if (that.data.esxxList && that.data.pages > 1) {
          esxxList = that.data.esxxList;
        }
        var datas = res.data.data;
        if (datas.length == 0) { //当没有数据时
          that.setData({
            isMoredata: false
          })
        } else { //当请求到数据时
          that.setData({
            isMoredata: true
          })
          for (var i = 0; i < datas.length; i++) { //把剩下的for循环加进去
            esxxList.push(datas[i])
          }
          that.setData({
            esxxList: esxxList,
          });
        }
      }
    })
  },

  xxDetailTap: function(e) {
    // wx.navigateTo({
    //   url: "/pages/es-details/index?id=" + e.currentTarget.dataset.id
    // })
  },

  xxEditTap: function(e) {
    wx.showToast({
      title: '该功能暂未开放，一周后启用。',
      icon: 'none',
      duration: 2000
    })
    // wx.navigateTo({
    //   url: "/pages/xy-fbxx/index?id=" + e.currentTarget.dataset.id
    // })
  },

  hireXxTap: function(e) {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    var goods_id = e.currentTarget.dataset.id;
    var ind = e.currentTarget.dataset.ind;
    wx.request({
      url: app.globalData.subDomain + '/user_es_goods_want',
      data: {
        user_id: user_id,
        goods_id: goods_id
      },
      success: function(res) {
        wx.showToast({
          title: '已赞美',
          icon: 'success',
          duration: 1000
        })
        var esxxList = that.data.esxxList;
        esxxList[ind]['is_want'] = 1;
        that.setData({
          esxxList: esxxList,
        });
      }
    })
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
    wx.showLoading({
      title: '加载中',
    })
    this.setData({
      pages: 1,
    })
    var that = this;
    setTimeout(function() {
      that.getXxList();
    }, 500)
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {
    var pages = this.data.pages;
    if (this.data.isHideLoadMore) {
      this.setData({
        isHideLoadMore: false,
      });
      if (this.data.isMoredata) {
        pages++;
        this.setData({
          pages: pages,
        });
      };
      setTimeout(() => {
        this.getXxList();
      }, 500)
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})
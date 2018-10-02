var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isclick: false,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(e) {
    var that = this;
    var id = e.id;
    if (id) {
      // 初始化原数据
      wx.showLoading();
      wx.request({
        url: app.globalData.subDomain + '/esxx_detail',
        data: {
          id: id
        },
        success: function (res) {
          wx.hideLoading();
          if (res.data.code == 0) {
            that.setData({
              id: id,
              esxxData: res.data.data
            });
            return;
          }
        }
      })
    }
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

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },

  fabuClick: function() {
    this.setData({
      isClick: true
    })
  },

  // 数据提交
  bindSave: function(e) {
    var that = this;
    var goods_name = e.detail.value.goods_name;
    var goods_price = e.detail.value.goods_price;
    var goods_for = e.detail.value.goods_for;
    var goods_desc = e.detail.value.goods_desc;

    if (goods_name == "") {
      wx.showModal({
        title: '提示',
        content: '请填写书名',
        showCancel: false
      })
      return
    }
    if (goods_price == "") {
      goods_price = 0;
    }
    if (goods_for == "") {
      wx.showModal({
        title: '提示',
        content: '请填写推荐理由',
        showCancel: false
      })
      return
    }
    if (goods_desc == "") {
      wx.showModal({
        title: '提示',
        content: '请填写内容简介',
        showCancel: false
      })
      return
    }

    var apiAddoRuPDATE = "add";
    var id = that.data.id;
    if (id) {
      apiAddoRuPDATE = "update";
    } else {
      id = 0;
    }

    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/user_xy_goods_add',
      data: {
        id: id,
        user_id: user_id,
        goods_name: goods_name,
        goods_desc: goods_desc
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
        // 跳转到消息列表
        wx.navigateTo({
          url: '/pages/xy-xxlb/index'
        })
      }
    })

  }

})
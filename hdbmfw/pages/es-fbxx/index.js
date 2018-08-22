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
    var goods_number = e.detail.value.goods_number;
    var goods_price = e.detail.value.goods_price;
    var goods_desc = e.detail.value.goods_desc;

    if (goods_name == "") {
      wx.showModal({
        title: '提示',
        content: '请填写物品名称',
        showCancel: false
      })
      return
    }
    if (goods_number == "") {
      wx.showModal({
        title: '提示',
        content: '请填写数量',
        showCancel: false
      })
      return
    }
    if (goods_price == "") {
      goods_price = 0;
    }
    if (goods_desc == "") {
      wx.showModal({
        title: '提示',
        content: '请填写物品详情',
        showCancel: false
      })
      return
    }

    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/user_es_goods_add',
      data: {
        user_id: user_id,
        goods_name: goods_name,
        goods_number: goods_number,
        goods_price: goods_price,
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
        wx.navigateBack({})
      }
    })

  }

})
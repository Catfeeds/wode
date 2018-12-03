var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isclick: false,
    id: 0,
    goods_thumb: "",
    imgs: "",
    count_imgs: 0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(e) {
    var that = this;
    var id = e.id;
    if (id) {
      // 初始化原数据
      that.data.id = id;
      wx.showLoading();
      wx.request({
        url: app.globalData.subDomain + '/esxx_detail',
        data: {
          id: id
        },
        success: function (res) {
          wx.hideLoading();
          if (res.data.code == 0) {
            var datas = res.data.data;
            var goods_imgs = datas.goods_img.split(',');
            that.setData({
              esxxData: res.data.data,
              goods_imgs: goods_imgs
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

  //上传
  clickUp: function (e) {
    var that = this;
    var id = that.data.id;
    var user_id = wx.getStorageSync('user_id');
    wx.chooseImage({
      count: 9, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        var tempFilePaths = res.tempFilePaths;
        // console.log(tempFilePaths);
        // return;
        var imgPath = tempFilePaths;
        that.data.goods_thumb = "";
        that.data.imgs = "";
        that.data.count_imgs = 0;
        for (var i = 0; i < imgPath.length; i++) {
          wx.uploadFile({
            url: app.globalData.subDomain + '/up_xuanyao',
            filePath: imgPath[i] + "",
            name: 'file',
            header: {
              'Accept': 'application/json'
            },
            success: function (res) {
              var resData = JSON.parse(res.data.trim())
              if (resData.code == 0) {
                that.data.count_imgs++;
                if (that.data.count_imgs == 1) {
                  that.data.goods_thumb = resData.data
                  that.data.imgs += resData.data;
                } else {
                  that.data.imgs += "," + resData.data;
                }
                if (that.data.count_imgs >= imgPath.length) {
                  // console.log(that.data.imgs);
                  var goods_imgs = that.data.imgs;
                  var goods_thumb = that.data.goods_thumb;
                  wx.request({
                    url: app.globalData.subDomain + '/up_xy_imgs',
                    method: 'POST',
                    data: {
                      id: id,
                      user_id: user_id,
                      goods_imgs: goods_imgs,
                      goods_thumb: goods_thumb,
                    },
                    success: function (res) {
                      wx.hideLoading();
                      if (res.data.code == 0) {
                        // that.setData({
                        //   esxxData: res.data.data
                        // });
                        that.data.id = res.data.data;
                        var goods_imgs = that.data.imgs.split(',');
                        that.setData({
                          goods_imgs: goods_imgs
                        });
                        wx.showToast({
                          title: '上传成功',
                        })
                        return;
                      }
                    }
                  })
                }
                // that.data.id = resData.data;
                // wx.showToast({
                //   title: '上传成功',
                // })
              } else {
                that.data.count_imgs++;
                if (that.data.count_imgs >= imgPath.length) { }
                wx.showModal({
                  content: resData.message,
                  success: function (res) { }
                })
              }
            }
          })
        }
      }
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

    var apiAddoRuPDATE = "add";
    var id = that.data.id;
    if (id) {
      apiAddoRuPDATE = "update";
    } else {
      id = 0;
    }

    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/user_es_goods_add',
      data: {
        id: id,
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
        wx.navigateTo({
          url: '/pages/es-xxlb/index'
        })
      }
    })

  }

})
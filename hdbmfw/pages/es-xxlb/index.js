var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pages: 1,
    isshangla: false,//是否为上拉加载
    isMoredata: true,//是否请求到数据
    isHideLoadMore: true,//是否显示加载更多.默认为true
  },

  /**
   * 跳转发布任务页面
   */
  fabuTask: function(e) {
    wx.navigateTo({
      url: "/pages/es-fbxx/index"
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
    this.getXxList();
  },

  getXxList: function() {
    var that = this;
    var pages = this.data.pages;
    wx.request({
      url: app.globalData.subDomain + '/esxx_list',
      data: {
        page: pages
      },
      success: (res) => {
        var esxxList = new Array();
        if (that.data.esxxList && that.data.pages > 1) {
          esxxList = that.data.esxxList;
        } else {
          that.setData({
            esxxList: []
          })
        }
        console.log("dswd");
        console.log(esxxList);
        wx.stopPullDownRefresh()
        wx.hideLoading();
        that.setData({
          isHideLoadMore: true
        })

        var datas = res.data.data;
        if (datas.length == 0) {//当没有数据时
          that.setData({
            isMoredata: false
          })
        } else {//当请求到数据时
          that.setData({
            isMoredata: true
          })
          for (var i = 0; i < datas.length; i++) {//把剩下的for循环加进去
            esxxList.push(datas[i])
          }
          console.log("111111111");
          console.log(esxxList);
          //点击上拉时需要显示的所有数据 
          if (that.data.isshangla) {
            that.setData({
              esxxList: esxxList,
              pages: pages,
            });
            //下拉时显示第一页的数据
          } else {
            that.setData({
              esxxList: datas,
            });
          }
        }


        // that.setData({
        //   esxxList: res.data.data
        // });
      }
    })
  },

  xxDetailTap: function(e) {

  },

  hireXxTap: function(e) {

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
      isshangla: false
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
      if (this.data.isMoredata) {
        pages++;
        this.setData({
          pages: pages,
          isshangla: true
        });
      }
      this.setData({
        isHideLoadMore: false,
      });
      setTimeout(() => {
        this.getXxList();
      }, 1000)
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})
// pages/my-help/index.js

var WxParse = require('../../wxParse/wxParse.js');
var isclick = false;
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isclick: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    // 获取分类
    wx.request({
      url: app.globalData.subDomain + '/category_list',
      method: 'GET',
      data: {
        parent_id: 1
      },
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        console.log('res.data is', res.data)
        if (res.data.code == 0) {
          that.setData({
            statusType: res.data.data
          });
        }
      }
    })

    // var that = this;
    // wx.request({
    //   url: app.globalData.subDomain + '/article_detail',
    //   success: function (res) {
    //     var datas = res.data.data
    //     console.log("帮助中心", res.data.data);
    //     // WxParse.wxParseTemArray("articleTemArray", 'article', datas.length, that)
    //     // WxParse.wxParse('article', 'html', datas[0].content, that, 25);

    //     var datas = res.data.data;
    //     var title = []
    //     for (let i = 0; i < datas.length; i++) {
    //       WxParse.wxParse('article' + i, 'html', datas[i].content, that);
    //       if (i === datas.length - 1) {
    //         WxParse.wxParseTemArray("articleArray", 'article', datas.length, that)
    //       }
    //       console.log("商城", datas[i].title);
    //       title.push(datas[i].title);
    //       datas[i].isclick = false;
    //     }
    //     that.setData({
    //       bgxyList: datas,
    //       title: title
    //     })
    //     console.log(datas)
    //   },
    //   tap() {
    //     console.log('tap')

    //   }
    // })
  },


  statusTap: function(e) {
    var curType = e.currentTarget.dataset.index;
    this.data.currentType = curType
    console.log('currentType is', this.data.currentType);
    this.setData({
      currentType: curType,
      isclick: !isclick
    });
    this.loadList();

  },


  loadList: function() {
    var that = this;
    var tp = 0;
    tp = that.data.currentType;
    wx.showLoading();
    console.log('that.data.currentType is', that.data.currentType);
    // 获取帮哥学院文章列表
    wx.request({
      url: app.globalData.subDomain + '/category_list',
      method: 'GET',
      data: {
        parent_id: tp
      },
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        console.log('文章列表 is', res.data);
        wx.hideLoading();
        if (res.data.code == 0) {
          var datas = res.data.data;
          that.setData({
            bgxyList: res.data.data
          });
          if (res.data.data.length == 0) {
            that.setData({
              bgxyList: ''
            });
          }
        }
      }
    })
  },

  clickTitle: function(e) {
    var that = this;
    //目前规则是打开第二个第一个要关闭上.然后单独每个可以打开和关闭
    for (var index = 0; index < this.data.bgxyList.length; index++) {
      //
      console.log('index=', index, 'bool is', this.data.bgxyList[e.currentTarget.dataset.index].isclick);
      if (index != e.currentTarget.dataset.index) { //不是当前选中的给关闭
        this.data.bgxyList[index].isclick = false;
      }
      if (index == e.currentTarget.dataset.index) { //是当前选中的取反
        this.data.bgxyList[e.currentTarget.dataset.index].isclick = !this.data.bgxyList[e.currentTarget.dataset.index].isclick
        var category_id = e.currentTarget.dataset.id;
        wx.request({
          url: app.globalData.subDomain + '/post_list',
          method: 'GET',
          data: {
            category_id: category_id
          },
          header: {
            'Accept': 'application/json'
          },
          success: function(res) {
            console.log('文章列表 is', res.data);
            wx.hideLoading();
            if (res.data.code == 0) {
              that.data.bgxyList[e.currentTarget.dataset.index].aaa = res.data.data;
              console.log(that.data.bgxyList);
              that.setData({
                bgxyList: that.data.bgxyList,
                clickTitle: e.currentTarget.dataset.index
              })
            }
          }
        })

      }
    }


  },

  clickPost: function(e) {
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: "../article-detail/index?id=" + id
    })

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

  }
})
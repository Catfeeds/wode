// pages/bgxy-detail/index.js
var util = require('../../utils/util.js');
var WxParse = require('../../wxParse/wxParse.js');
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id: 0,
    bgxywz: null,
    title: "",
    curName: ""
  },

  dataCode: function(data) {
    var newDate = new Date();
    newDate.setTime(data * 1000);
    return util.formatDate(newDate);
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(e) {
    this.data.id = e.id;
    if (e.curName) {
      this.data.curName = e.curName;
      wx.setNavigationBarTitle({
        title: e.curName
      })
    }
    if (e.isBack) {
      this.setData({
        isBack: 1
      });
    } else {
      this.setData({
        isBack: 0
      });
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
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.showLoading();
    // 获取文章
    wx.request({
      url: app.globalData.subDomain + '/article_detail_user',
      method: 'GET',
      data: {
        id: that.data.id,
        user_id: user_id
      },
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        if (res.data.code == 0) {
          var datas = res.data.data;
          datas.published_time = that.dataCode(datas.published_time);
          that.data.title = datas.post_title;
          that.data.bgxywz = datas;
          that.setData({
            bgxywz: datas
          });
          if (!datas.post_content) {
            datas.post_content = "小编努力整理中(ง •_•)ง 敬请期待~~ <br> 欢迎点击右下方投稿(*^__^*) ";
          }
          WxParse.wxParse('article', 'html', datas.post_content, that, 5);
          wx.hideLoading();
        }
      }
    })
  },

  toHomePage: function() {
    wx.switchTab({
      url: '/pages/qzh/index'
    })
  },

  toBackPage: function() {
    wx.navigateBack({})
  },

  toMorePage: function() {
    wx.switchTab({
      url: '/pages/first-nav/index'
    })
  },

  toLike: function() {
    var that = this;
    if (!this.data.bgxywz) {
      return;
    }
    var user_id = wx.getStorageSync('user_id');
    var bgxywz = this.data.bgxywz;
    var if_like = bgxywz.if_like;
    wx.request({
      url: app.globalData.subDomain + '/article_like',
      data: {
        id: that.data.id,
        if_like: if_like,
        user_id: user_id
      },
      success: function(res) {
        if (if_like) {
          bgxywz.if_like = 0;
          bgxywz.post_like -= 1;
          that.setData({
            bgxywz: bgxywz
          });
          wx.showToast({
            title: '取消点赞成功',
            icon: 'none',
            duration: 2000
          })
        } else {
          bgxywz.if_like = 1;
          bgxywz.post_like += 1;
          that.setData({
            bgxywz: bgxywz
          });
          wx.showToast({
            title: '点赞成功',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
  },

  toCollect: function() {
    var that = this;
    if (!this.data.bgxywz) {
      return;
    }
    var user_id = wx.getStorageSync('user_id');
    var bgxywz = this.data.bgxywz;
    var if_collect = bgxywz.if_collect;
    wx.request({
      url: app.globalData.subDomain + '/article_collect',
      data: {
        id: that.data.id,
        if_collect: if_collect,
        user_id: user_id
      },
      success: function(res) {
        if (if_collect) {
          bgxywz.if_collect = 0;
          bgxywz.post_collect -= 1;
          that.setData({
            bgxywz: bgxywz
          });
          wx.showToast({
            title: '取消收藏成功',
            icon: 'none',
            duration: 2000
          })
        } else {
          bgxywz.if_collect = 1;
          bgxywz.post_collect += 1;
          that.setData({
            bgxywz: bgxywz
          });
          wx.showToast({
            title: '收藏成功',
            icon: 'none',
            duration: 2000
          })
        }
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
    return {
      title: this.data.curName, //this.data.title,
      path: "/pages/article-detail/index?id=" + this.data.id + "&curName=" + this.data.curName,
      success: function(res) {
        // 转发成功
      },
      fail: function(res) {
        // 转发失败
      }
    }
  }
})
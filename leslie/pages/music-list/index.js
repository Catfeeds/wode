// pages/my-help/index.js

var isclick = false;
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isclick: false,
    currentName:"专辑"
  },

  buttonTap: function (e) {
    var user_id = wx.getStorageSync('user_id');
    app.addForm(e.detail.formId, user_id);

    var keyword = e.detail.value.keyword;
    wx.navigateTo({
      url: "/pages/search/index?keyword=" + keyword
    })
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
        if (res.data.code == 0) {
          that.setData({
            statusType: res.data.data,
            currentType: 7,
            isclick: !isclick
          });
          that.loadList();
        }
      }
    })
  },

  statusTap: function(e) {
    var curType = e.currentTarget.dataset.index;
    var curName = e.currentTarget.dataset.name;
    this.data.currentType = curType;
    this.data.currentName = curName;
    this.setData({
      currentType: curType,
      isclick: !isclick
    });
    this.loadList();
  },

  loadList: function() {
    var that = this;
    var tp = that.data.currentType;
    wx.showLoading();
    that.setData({
      bgxyList: [],
      bgxyList2: []
    });
    // 获取分类列表
    if (tp!=10 && tp!=14){
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
        wx.hideLoading();
        if (res.data.code == 0) {
          var datas = res.data.data;
          that.setData({
            bgxyList: res.data.data
          });
          // if (res.data.data.length == 0) {
          //   that.setData({
          //     bgxyList: ''
          //   });
          // }
        }
      }
    })
    }else{
    wx.request({
      url: app.globalData.subDomain + '/post_list',
      method: 'GET',
      data: {
        category_id: tp
      },
      header: {
        'Accept': 'application/json'
      },
      success: function (res) {
        wx.hideLoading();
        if (res.data.code == 0) {
          var datas = res.data.data;
          that.setData({
            bgxyList2: res.data.data
          });
          // if (res.data.data.length == 0) {
          //   that.setData({
          //     bgxyList: ''
          //   });
          // }
        }
      }
    })
    }
  },

  clickTitle: function(e) {
    var that = this;
    var cur = e.currentTarget.dataset.index;
    //目前规则是打开第二个第一个要关闭上.然后单独每个可以打开和关闭
    for (var index = 0; index < this.data.bgxyList.length; index++) {
      if (index != cur) { //不是当前选中的给关闭
        this.data.bgxyList[index].isclick = false;
      }
      else { //是当前选中的取反
        this.data.bgxyList[cur].isclick = !this.data.bgxyList[cur].isclick;
        if (this.data.bgxyList[cur].isclick){
          var category_id = e.currentTarget.dataset.id;
          var curName = e.currentTarget.dataset.name;
          this.data.currentName = curName;
          wx.request({
            url: app.globalData.subDomain + '/post_list',
            method: 'GET',
            data: {
              category_id: category_id
            },
            header: {
              'Accept': 'application/json'
            },
            success: function (res) {
              wx.hideLoading();
              if (res.data.code == 0) {
                that.data.bgxyList[cur].aaa = res.data.data;
                that.setData({
                  bgxyList: that.data.bgxyList,
                  clickTitle: cur
                })
              }
            }
          })
        }
      }
    }
  },

  clickPost: function(e) {
    var id = e.currentTarget.dataset.id;
    var curName = this.data.currentName;
    wx.navigateTo({
      url: "../article-detail/index?id=" + id + "&curName=" + curName + "&isBack=1"
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
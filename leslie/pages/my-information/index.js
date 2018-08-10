var app = getApp();
Page({
  data: {
    userInfo: {},
    imgPath: ''
  },
  /*
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
  },
  onShow: function() {
    this.getUserInfo();
  },
  getUserInfo: function() {
    this.setData({
      userInfo: app.globalData.userInfo,
      userAvatar: app.globalData.userInfo.avatar
    });
  },
  //上传头像
  clickUp: function(e) {
    var that = this;
    var user_id = wx.getStorageSync('user_id');
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function(res) {
        var tempFilePaths = res.tempFilePaths;
        that.setData({
          imgPath: tempFilePaths
        })
        wx.uploadFile({
          url: app.globalData.subDomain + '/touxiang?user_id=' + user_id,
          filePath: that.data.imgPath + "",
          name: 'file',
          header: {
            'Accept': 'application/json'
          },
          success: function(res) {
            var resData = JSON.parse(res.data.trim())
            if (resData.code == 0) {
              wx.showToast({
                title: '更改成功',
              })
              //保存用户头像
              that.setData({
                userAvatar: resData.data.avatar
              })
              // app.globalData.userInfo.avatar = resData.data.avatar;
            } else {
              wx.showModal({
                content: resData.message,
                success: function(res) {
                  if (res.confirm) {

                  } else if (res.cancel) {

                  }
                }
              })
            }
          }
        })
      }
    })
  },
  //表单数据提交
  formSubmit: function(e) {
    var that = this;
    var param = e.detail.value;
    //都填写正确了再判断验证码是否正确
    if (param.realname.length == 0) {
      wx.showToast({
        title: '昵称不能为空',
      })
      return;
    }
    var user_id = wx.getStorageSync('user_id');
    wx.request({
      url: app.globalData.subDomain + '/up_user_detail',
      method: 'POST',
      data: {
        user_id: user_id,
        user_name: param.realname,
        mobile: param.mobile
      },
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        //提交成功
        if (res.data.code == 0) {
          that.data.userInfo.user_name = param.realname;
          that.data.userInfo.mobile = param.mobile;
          // app.globalData.userInfo.user_name = param.realname;
          // app.globalData.userInfo.mobile = param.mobile;
          wx.showModal({
            content: '修改成功',
            success: function(res) {
              wx.navigateBack({})
            }
          })
        }
      }
    })
  }
})
var utils = (function () {
  var time = new Date()
  return {
    year: time.getFullYear(),
    month: time.getMonth() + 1,
    date: time.getDate(),
    hours: time.getHours(),
    minutes: time.getMinutes()
  }
})()
var app = getApp()
Page({
  data: {
    taskid:'',  //活动的id号
    title: '', //活动标题
    date: '', //活动日期
    time: '', //活动时间
    address: '',
    name: '',
    tel: '',
    remark: '',
  },
  onLoad: function () {
    var that = this;
    that.setData({
      date: utils.year + '-' + ('0' + utils.month).substr(-2) + '-' + ('0' + utils.date).substr(-2),
      time: ('0' + utils.hours).substr(-2) + ':' + ('0' + utils.minutes).substr(-2)
    })
  },
  bindDateChange: function (e) {
    var that = this;
    that.setData({
      date: e.detail.value,
    })
  },
  bindTimeChange: function (e) {
    var that = this;
    that.setData({
      time: e.detail.value,
    })
  },
  bindTitleInput: function (e) {
    var that = this;
    that.setData({
      title: e.detail.value,
    });
  },
  bindAddressInput: function (e) {
    var that = this;
    that.setData({
      address: e.detail.value,
    });
  },
  bindNameInput: function (e) {
    var that = this;
    that.setData({
      name: e.detail.value,
    });
  },
  bindTelInput: function (e) {
    var that = this;
    that.setData({
      tel: e.detail.value,
    });
  },
  bindRemarkInput: function (e) {
    var that = this;
    that.setData({
      remark: e.detail.value,
    });
  },
  getMap: function () {
    var that = this;
    var chooseAddress = function () {
      wx.chooseLocation({
        type: 'gcj02', //返回可以用于wx.openLocation的经纬度
        success: function (res) {
          var latitude = res.latitude
          var longitude = res.longitude
          that.setData({
            address: res.name + '(' + res.address + ')'
          })
        }
      })
    }
    wx.getSetting({
      success: (res) => {
        if (res.authSetting['scope.userLocation'] == false) {
          wx.openSetting({
            success: (res) => {
              console.log('成功打开设置')
              chooseAddress()
            }
          })
        } else {
          chooseAddress()
        }
      }
    })
  },
  ok: function () {
    var that = this;
    if (that.data.title == '') {
      wx.showModal({
        title: '警告!',
        content: '标题必需填写',
        success: function (res) {
          
        }
      })
    } else {
      wx.showLoading({
        title: '创建中...',
      })
      that.setData({
        taskid: new Date().getTime().toString() + parseInt(Math.random() * 10000000)//创建时间+随机数
      })
      var user_id = wx.getStorageSync('user_id');
      wx.request({
        url: app.globalData.subDomain + '/creatjielongtask',
        data: {
          user_id: user_id,  //openid对应taskid
          taskid: that.data.taskid,  //用创建的时间作为活动的id号
          title: that.data.title, //活动标题
          date: that.data.date, //活动日期
          time: that.data.time, //活动时间
          address: that.data.address,
          name: that.data.name,
          tel: that.data.tel,
          remark: that.data.remark, 
        },
        dataType: 'JSONP',
        success: function (res) {
          wx.hideLoading();
          wx.redirectTo({
            url: '../enroll/enroll?taskid=' + that.data.taskid
          })
        }
      });
    }
  }
})
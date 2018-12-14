var app = getApp()
//var p = new Promise(function (resolve, reject) {  //创建promise，确保页面加载数据前已经加载了openid!
//  wx.login({
//    success: function (res) {
//      if (res.code) {
//        wx.request({
//          url: app.globalData.host + '/application/link/getOpenid.php',
//          data: {
//            appid: app.globalData.AppID,
//            secret: app.globalData.secret,
//            js_code: res.code,
//            grant_type: 'authorization_code'
//          },
//          dataType: 'JSONP',
//          success: function (res) {  //服务端请求并存储openid,并发送openid过来
//            var data0 = JSON.parse(res.data);
//            app.globalData.openid = data0.openid;
//            resolve();
//          }
//        })
//      } else {
//        console.log('获取用户登录态失败！' + res.errMsg)
//      }
//    }
//  });
//})

Page({
  data: {
    taskid: '',
    taskData: '', //任务详细数据，如标题，发起人等
    joinerData: '', //参与活动的人员详情列表数据
    viewerData: '', //访问了该任务的人员全部数据
    viewerNumber: '', //访问了该任务的人员数量
    joinerNumber: '', //参与了该任务的人员数量
    okWord: '立即报名',
    enrollToast: false,
    joinerName: '',
    joinerTel: '',
    joinerRemark: '',
  },
  onLoad: function(opt) {
    app.globalData.fromClickId = opt.fromClickId
    wx.showShareMenu({
      withShareTicket: true
    })
    var that = this;
    that.setData({
      taskid: opt.taskid,
    })
    wx.showLoading({
      title: '加载中...',
    })
    var user_id = wx.getStorageSync('user_id');
    wx.request({ //请求活动任务的详情数据
      url: app.globalData.subDomain + '/getjielongtask',
      data: {
        user_id: user_id,
        taskid: opt.taskid,
      },
      // dataType: 'JSONP',
      success: function(res) {
        wx.hideLoading();
        console.log(res.data)
        var data0 = res.data.data; //JSON.parse(res.data)[0]
        console.log(app.globalData.userInfo)
        that.setData({
          taskData: data0
        })
        if (data0.is_join) {
          that.setData({
            okWord: '修改',
            joinerName: app.globalData.userInfo.user_name,
          })
        } else {
          that.setData({
            okWord: '立即报名',
            joinerName: app.globalData.userInfo.user_name,
          })
        }
        // wx.request({  //请求任务的参与者列表
        //   url: `${app.globalData.host}/application/link/getTaskJoiner.php`,
        //   data: {
        //     taskid: opt.taskid,
        //   },
        //   dataType: 'JSONP',
        //   success: function (res) {
        //     var data0 = JSON.parse(res.data);
        //     that.setData({
        //       joinerData: data0
        //     })
        //   }
        // });
      }
    });
    // p.then(function () {
    //   wx.request({  //请求将浏览了该活动的用户openid存储到数据库，不重复插入,以统计有多少浏览量
    //     url: app.globalData.host + '/application/link/viewjielongtask.php',
    //     data: {
    //       openid: app.globalData.openid,
    //       taskid: opt.taskid,
    //     },
    //     dataType: 'JSONP',
    //     success: function (res) {
    //       var data0 = JSON.parse(res.data);
    //       var joinerNumber0 = 0;
    //       for (var i = 0; i < data0.length; i++) {  //计算有多少参与者
    //         if (data0[i].userid) {
    //           joinerNumber0++
    //         }
    //       }
    //       that.setData({
    //         viewerData: data0,
    //         viewerNumber: data0.length,
    //         joinerNumber: joinerNumber0,
    //       })
    //       var enroll = function (data) {  //定义立即报名状态判定模块
    //         var enrolledResult = false;
    //         for (var i = 0; i < data.length; i++) {
    //           if (data[i].userid == app.globalData.openid) {
    //             enrolledResult = true;
    //             break;
    //           }
    //         }
    //         if (enrolledResult) {
    //           that.setData({
    //             okWord: '修改',
    //             joinerName: app.globalData.userInfo.nickName,
    //           })
    //         } else {
    //           that.setData({
    //             okWord: '立即报名',
    //             joinerName: app.globalData.userInfo.nickName,
    //           })
    //         }
    //       }
    //       enroll(data0);  //获取立即报名按钮状态
    //     }
    //   });
    // })

  },
  onShareAppMessage: function(res) {
    var that = this;
    return {
      path: `/pages/link/enroll/enroll?taskid=${that.data.taskid}&fromClickId=${app.globalData.clickId}`,
      success: function(res) {

      },
      fail: function(res) {
        // 转发失败
      }
    }
  },
  ok: function() {
    var that = this;
    that.setData({
      enrollToast: true,
    })
  },
  cancel: function() {
    var that = this;
    that.setData({
      enrollToast: false,
    })
  },
  bindJoinerNameInput: function(e) {
    var that = this;
    that.setData({
      joinerName: e.detail.value,
    });
  },
  bindJoinerTelInput: function(e) {
    var that = this;
    that.setData({
      joinerTel: e.detail.value,
    });
  },
  bindJoinerRemarkInput: function(e) {
    var that = this;
    that.setData({
      joinerRemark: e.detail.value,
    });
  },
  join: function() {
    var that = this;
    wx.showLoading({
      title: '加载中...',
    })
    var user_id = wx.getStorageSync('user_id');
    wx.request({ //加入此活动，并将用户更多信息存入数据库
      url: app.globalData.subDomain + '/joinjielongtask',
      data: {
        user_id: user_id,
        taskid: that.data.taskid,
        joinerName: that.data.joinerName,
        joinerTel: that.data.joinerTel,
        joinerRemark: that.data.joinerRemark,
      },
      // dataType: 'JSONP',
      success: function(res) {
        wx.hideLoading();
        if (res.data.code) {
          wx.showToast({
            title: res.data.message,
            icon: 'none',
            duration: 2000
          });
          return;
        }
        wx.showToast({
          title: '报名成功',
          icon: 'success',
          duration: 2000
        });
        that.setData({
          okWord: '已报名',
          joinerNumber: Number(that.data.joinerNumber) + 1,
          enrollToast: false,
        });
        wx.redirectTo({ //刷新页面
          url: '../enroll/enroll?taskid=' + that.data.taskid
        })
      }
    });
  },
})
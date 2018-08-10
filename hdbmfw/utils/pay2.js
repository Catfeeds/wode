var util = require('util.js');
function wxpay(app, money, orderId, redirectUrl) {
  let remark = "在线充值";
  let nextAction = {};
  if (orderId != 0) {
    remark = "支付订单 ：" + orderId;
    nextAction = { type: 0, id: orderId };
  }

  wx.login({
    success: function (res0) {
      console.log('code:', res0.code)
      if (res0.code) {
        wx.request({
          url: 'https://lmbge.com/wxapi/ymall/wxpay1',
          data: {
            weixin: res0.code,
            id: orderId
          },
          //method:'POST',
          success: function (res) {
            var result = res.data.data;
            console.log(res.data)
            if (res.data.code == 0) {
              var prepay_id = result.package.replace("prepay_id=", "");
              // 发起支付
              wx.requestPayment({
                timeStamp: result.timeStamp,
                nonceStr: result.nonceStr,
                package: result.package,
                signType: result.signType,
                paySign: result.paySign,
                fail: function (aaa) {
                  wx.showToast({ title: '支付失败' }) // + aaa.errMsg
                },
                success: function () {
                  wx.showToast({ title: '支付成功' })
                  wx.request({
                    url: 'https://lmbge.com/wxapi/ymall/paysuccess',
                    data: {
                      id: orderId
                    },
                    success: (res) => {
                      if (res.data.code == 0) {
                        var order_info = res.data.data;
                        var newDate = new Date();
                        newDate.setTime(order_info.add_time * 1000);
                        var add_time = util.formatTime(newDate);
                        var data_arr = {};
                        data_arr.keyword1 = { value: add_time, color: '#173177' }
                        data_arr.keyword2 = { value: '￥' + order_info.order_amount, color: '#173177' }
                        data_arr.keyword3 = { value: order_info.order_sn, color: '#173177' }
                        data_arr.keyword4 = { value: order_info.consignee, color: '#173177' }
                        data_arr.keyword5 = { value: order_info.region + ' ' + order_info.address, color: '#173177' }
                        //app.sendTempleMsg('WZE85ef1y2J_8W4E2CtwcrTMhRX5SNeE5ZSq6lSurKc', prepay_id,
                        //  '/pages/Shop/order-details/index?id=' + order_info.id, data_arr);
                      }
                    }
                  })
                  wx.reLaunch({
                    url: redirectUrl
                  });
                }
              })
            } else {
              wx.showToast({ title: '服务器忙' + res.data.code + res.data.msg })
            }
          }
        })
      }
    }
  })

}

module.exports = {
  wxpay: wxpay
}

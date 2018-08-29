// pages/search/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    goods: [],
    //分页
    parampage: 1,
    ssButton: "取消",
    buttonClass: "",
    keyword: "",
    statusType: ["综合", "销量", "价格", "筛选"],
    currentType: "",
    isclick: false,

    //筛选选择后回传的数据
    pricelow: 0,
    pricehigh: 0,
    pinpaiid: [],
    gongzhongid: [],
    catid: "",
    //paramkey, paramorder, paramsort,
    //parampricemax, parammin, parambrand, prarmgongzhong, parampage
    //加载更多时传递的参数
    paramorder: "",
    paramsort: ""
  },
  //当nav被点击的时候
  statusTap: function(e) {
    console.log("tab:", e.currentTarget.dataset.index);
    this.setData({
      currentType: e.currentTarget.dataset.index
    })
    if (e.currentTarget.dataset.index == '0') {
      this.setData({
        goods: [],
        parampage: 1,
        pricelow: 0,
        pricehigh: 0,
        pinpaiid: [],
        gongzhongid: [],
        paramorder: "",
        paramsort: ""
      })
      //综合
      this.getGoodsList(this.data.region_id, this.data.keyword, '', '', '', '', '', '', this.data.parampage);
    } else if (e.currentTarget.dataset.index == '1') {
      //销量 高到低
      this.setData({
        goods: [],
        paramorder: "desc",
        paramsort: "salenum",
        pricehigh: 0,
        pricelow: 0,
        pinpaiid: [],
        gongzhongid: [],
        parampage: 1,
      })

      this.getGoodsList(this.data.region_id, this.data.keyword, this.data.paramorder,
        this.data.paramsort, this.data.pricehigh, this.data.pricelow, '', '', this.data.parampaage);

    } else if (e.currentTarget.dataset.index == '2') {
      //价格
      var isclick = !this.data.isclick;
      console.log(isclick)
      this.setData({
        isclick: isclick
      })
      if (this.data.isclick == false) {
        //高到低
        this.setData({
          goods: [],
          paramorder: "desc",
          paramsort: "shop_price",
          pricehigh: 0,
          pricelow: 0,
          pinpaiid: [],
          gongzhongid: [],
          parampage: 1,
        })
        this.getGoodsList(this.data.region_id, this.data.keyword, this.data.paramorder,
          this.data.paramsort, this.data.pricehigh, this.data.pricelow, '', '', this.data.parampaage);
      } else {
        //低到高
        this.setData({
          goods: [],
          paramorder: "asc",
          paramsort: "shop_price",
          pricehigh: 0,
          pricelow: 0,
          pinpaiid: [],
          gongzhongid: [],
          parampage: 1,
        })
        this.getGoodsList(this.data.region_id, this.data.keyword, this.data.paramorder,
          this.data.paramsort, this.data.pricehigh, this.data.pricelow, '', '', this.data.parampaage);
      }
    } else {
      //筛选
      wx.navigateTo({
        url: '/pages/Shop/search-shaixuan/index?keyword=' + this.data.keyword + '&&cat_id=' + this.data.catid,
      })
    }
  },
  // 当键盘输入时
  searchIpt: function(e) {
    if (e.detail.value == "") {
      this.setData({
        ssButton: "取消",
        buttonClass: ""
      })
    } else {
      this.setData({
        ssButton: "确定",
        buttonClass: "queding",
        keyword: e.detail.value
      })
    }

  },
  //当点击价格排序的时候
  jiageTap: function(e) {
    var isclick = !this.data.isclick;
    console.log(isclick)
    this.setData({
      isclick: isclick
    })
  },
  buttonTap: function() {
    if (this.data.ssButton == "确定") {
      this.setData({
        goods: [],
        parampage: 1
      })
      var pinpaiid = this.data.pinpaiid.toString().substring(0, this.data.pinpaiid.toString().length);
      this.getGoodsList(this.data.region_id, this.data.keyword, this.data.paramorder,
        this.data.paramsort, this.data.pricehigh, this.data.pricelow, pinpaiid, '', this.data.parampage);
    } else {
      wx.navigateBack();
    }
  },
  //条件筛选后
  shaixuan: function() {
    this.setData({
      goods: [],
      paramorder: "",
      paramsort: "",
      parampage: 1
    })
    var id = this.data.pinpaiid.toString().substring(0, this.data.pinpaiid.toString().length);

    console.log(id)
    this.getGoodsList(this.data.region_id, this.data.keyword, this.data.paramorder, this.data.paramsort, this.data.pricehigh, this.data.pricelow, id, '', this.data.parampage);
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    var region_id = wx.getStorageSync('region_id');
    if (options.keyword == undefined) {
      options.keyword = "";
    }
    if (options.gongzhongid == undefined) {
      options.gongzhongid = "";
    }
    this.setData({
      ssButton: "确定",
      buttonClass: "queding",
      keyword: options.keyword,
      catid: options.gongzhongid,
      region_id: region_id
    })
    if (that.data.catid != "") {
      this.getGoods(that.data.catid, that.data.region_id);
      console.log("?/??", that.data.region_id)

    } else {
      this.getGoodsList(that.data.region_id, options.keyword, '', '', '', '', '', '', this.data.parampage);
    }

  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

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
    var that = this;
    var page = that.data.parampage;
    page = page + 1;
    this.setData({
      parampage: page
    })
    console.log(this.data.procehigh)
    var pinpaiid = this.data.pinpaiid.toString().substring(0, this.data.pinpaiid.toString().length);
    this.getGoodsList(that.data.region_id, this.data.keyword, this.data.paramorder,
      this.data.paramsort, this.data.pricehigh, this.data.pricelow, pinpaiid, '', this.data.parampage);


  },
  //商品列表
  getGoodsList: function(region_id, paramkey, paramorder, paramsort,
    parampricemax, parammin, parambrand, prarmgongzhong, parampage) {
    var that = this;
    wx.showLoading();
    wx.request({
      url: 'small/search',
      data: {
        region_id: region_id,
        cat_id: that.data.catid,
        keyword: paramkey,
        order: paramorder,
        sort: paramsort,
        price_max: parampricemax,
        price_min: parammin,
        brand: parambrand,
        gongzhong: prarmgongzhong,
        page: parampage
      },
      success: function(res) {
        wx.hideLoading();
        console.log(res)
        var datas = res.data.data;
        //如果没有数据了，就关闭加载更多
        if (datas.length > 0) {
          var goods = that.data.goods;
          for (var i = 0; i < datas.length; i++) {
            goods.push(datas[i])
          }
          that.setData({
            goods: goods,
          });
        }
      },
      fail: function() {
        wx.hideLoading();
      }
    })
  },
  // 商品列表
  getGoods: function(gongzhongid, region_id, parampage) {
    wx.showLoading();
    var that = this;
    wx.request({
      url: 'small/goods',
      data: {
        cat_id: gongzhongid,
        region_id: region_id,
        page: parampage
      },
      success: function(res) {
        wx.hideLoading();
        console.log(res)
        for (var i = 0; i < res.data.data.length; i++) {
          that.data.goods.push(res.data.data[i])
        }
        console.log(that.data.goods)
        that.setData({
          goods: that.data.goods,

        });
      }
    })
  },
  toGoodDetailsTap: function(e) {
    wx.navigateTo({
      url: "/pages/Shop/goods-details/index?id=" + e.currentTarget.dataset.id + "&&gongzhong=" + this.data.gongzhongid
    })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})
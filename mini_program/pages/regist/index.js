const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    windowHeight:null,
    windowWidth:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      var that = this;
      that.setData({
        windowHeight:app.getHeight(),
        windowWidth: app.getWidth()
      })
  },

  regist: function (e) {
    wx.showLoading({
      title: '登录 中......',
    })
    wx.request({
      url: app.globalData.url+'users/regist',
      data: {
        'username': e.detail.value.username,
        'password': e.detail.value.password,
        'nickname': e.detail.value.username,
      },
      method:'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        if(res.data.code == 200) {
          wx.showToast({
            title: "登录成功",
            icon: 'success',
            duration: 2000
          })
          app.setGlobalUserInfo(res.data.data);
          wx.redirectTo({
            url: "../mine/mine",
          })
        }else {
          wx.showToast({
            title: res.data.msg,
            icon:'none',
            duration: 2000
          })
        }
        wx.hideLoading({})
      },
      fail:()=>{
        wx.showToast({
          title: '网络异常......',
          icon:'none',
          duration:3000
        })
      }
    })
  },
  /**
   * 跳转到登录页面
   */
  goLoginPage: function () {
    wx.redirectTo({
      url: '../login/login',
    })
  }

})
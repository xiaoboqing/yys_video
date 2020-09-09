//app.js
App({
  
  onLaunch: function () {
  },

/**获取设备的高度 */
  getHeight() {
    var windowHeight = null;
      wx.getSystemInfo({
        success(res) {
          windowHeight = res.windowHeight
        },
      })
    return windowHeight;
  },

/**获取设备的宽度 */
  getWidth() {
    var windowWidth = null;
    wx.getSystemInfo({
      success(res) {
        windowWidth = res.windowWidth
      },
    })
    return windowWidth;
  },
  globalData: {//全局变量
    url:"http://127.0.0.1:8099/",
    userInfo:null
  },

  setGlobalUserInfo(data) { 
      wx.setStorageSync('userInfo', data)
  },

  clearGlobalUserInfo() {
    wx.removeStorageSync('userInfo');
  },

  getGlobalUserInfo() {
    return wx.getStorageSync("userInfo");
  }


    
    

})
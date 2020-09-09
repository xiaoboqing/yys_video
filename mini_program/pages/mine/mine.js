
const app = getApp()

Page({
  data: {
    faceUrl: "../../images/noneface.png",
    isMe: true,   //当前页面属于谁 
    isFollow: false,  //是否关注
    fansCounts: 1,  //粉丝数量
    followCounts: 2,  //关注数量
    receiveLikeCounts: 3,  //获赞数量
    nickname:"兿颩颩"  //昵称
  },

  onLoad: function () {
    var that = this;
    var userinfo = app.getGlobalUserInfo();

    if(undefined != userinfo) {
      that.setData({
        nickname:userinfo.nickname,
        faceUrl:userinfo.faceImage == null ? "../../images/noneface.png" : app.globalData.url + userinfo.faceImage,
        fansCounts:userinfo.fansCounts,
        followCounts: userinfo.fansCounts,  //关注数量
        receiveLikeCounts: userinfo.receiveLikeCounts,  //获赞数量
      })
    }
  },

  /**
   * 注销登录
   */
  logout: function () {
    app.clearGlobalUserInfo()
    wx.redirectTo({
      url: '../login/login',
    })
  },

  /**
   * 修改用户头像
   */
  changeFace: function () {
    var that = this;

    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths;
        wx.showLoading("图片上传中......")
        wx.uploadFile({
          url: app.globalData.url + "users/upload?userId=" + app.getGlobalUserInfo().id,      //此处换上你的接口地址
          filePath: tempFilePaths[0],
          name: 'files',
          header: {
            'content-type': 'multipart/form-data'
          },
          success: function(res){
            var data=JSON.parse(res.data);
            that.setData({
              faceUrl:app.globalData.url + data.data
            })
            wx.hideLoading()
            wx.showToast({
              title: '修改成功',
              duration: 2000
            })
          },
          fail: function(res){
            console.log('fail');
 
          },
        })
      }
    })

  }

})

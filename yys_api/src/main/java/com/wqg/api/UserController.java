package com.wqg.api;

import com.wqg.common.ret.RetResponse;
import com.wqg.common.ret.RetResult;
import com.wqg.i_yys_service.IUsersService;
import com.wqg.vo.UserVO;
import com.wqg.yys_pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 小程序接口
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUsersService iUsersService;

    /**
     * 根据用户id获取用户信息
     */
    @RequestMapping("/selectUserById")
    public void selectUserById() {

        Users users = iUsersService.selectByPrimaryKey("180425BNSR1CG0H0");
        System.out.println(users.toString());
    }

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public RetResult login(@RequestBody Users users) {
        //判断参数是否为空
        if(StringUtils.isEmpty(users.getUsername()) || StringUtils.isEmpty(users.getPassword())) {
            return RetResponse.makeRsp(400,"用户名或密码不能为空");
        }
        //判断用户名是否存在
        UserVO user = iUsersService.findUserByUserNameAndPassword(users.getUsername(),users.getPassword());
        if(!ObjectUtils.isEmpty(user)) {
            return RetResponse.makeRsp(200,"success", user);
        }

        return RetResponse.makeRsp(400,"注册失败");
    }

    /**
     * 用户注册
     */
    @RequestMapping("/regist")
    public RetResult regist(@RequestBody Users users) {
        //判断参数是否为空
        if(StringUtils.isEmpty(users.getUsername()) || StringUtils.isEmpty(users.getPassword())) {
            return RetResponse.makeRsp(400,"用户名或密码不能为空");
        }
        //判断用户名是否存在
        Boolean isExist = iUsersService.findUserByUserName(users.getUsername());
        if(isExist) {
            return RetResponse.makeRsp(400,"用户名已存在");
         }

        //添加用户
        try {
            Boolean isSave = iUsersService.save(users);
            if(isSave) {
                return RetResponse.makeRsp(200,"success");
            }
        } catch (Exception e) {

        }
        return RetResponse.makeRsp(400,"注册失败");
    }
}

package com.wqg.controller;

import com.wqg.i_yys_service.IUsersService;
import com.wqg.yys_pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户controller层
 */
@RestController
@RequestMapping("users")
public class UsersController {

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
}

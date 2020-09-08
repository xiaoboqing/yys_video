package com.wqg.i_yys_service;

import com.wqg.vo.UserVO;
import com.wqg.yys_pojo.Users;

/**
 * 用户service层接口
 */

public interface IUsersService {

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    Users selectByPrimaryKey(String id);

    /**
     * 根据用户 名查询用户信息
     * @param userName
     * @return
     */
    Boolean findUserByUserName(String userName);

    /**
     * 添加用户
     * @param users
     * @return
     */
    Boolean save(Users users);

    /**
     * 根据用户名和密码查询用户
     * @return
     */
    UserVO findUserByUserNameAndPassword(String userName, String password);
}

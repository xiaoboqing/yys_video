package com.wqg.yys_service;

import com.wqg.common.md5.MD5Util;
import com.wqg.i_yys_service.IUsersService;
import com.wqg.vo.UserVO;
import com.wqg.yys_mapper.UsersMapper;
import com.wqg.yys_pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

/**
 * 用户service层实现类
 */
@Service
public class UsersService implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;


    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @Override
    public Users selectByPrimaryKey(String id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户名和密码获取用户
     * @param userName
     * @param password
     * @return
     */
    @Override
    public UserVO findUserByUserNameAndPassword(String userName, String password) {
        String newPassword = MD5Util.MD5(password);
        return usersMapper.findUserByUserNameAndPassword(userName, newPassword);
    }

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    @Override
    public Boolean findUserByUserName(String userName) {
        return ObjectUtils.isEmpty(usersMapper.selectByName(userName)) ? false : true;
    }

    /**
     * 更新用户信息
     * @param users
     */
    @Override
    public Boolean updata(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users) > 0 ? true : false;
    }

    /**
     * 添加用户
     * @param users
     * @return
     */
    @Override
    @Transactional
    public Boolean save(Users users) {
        users.setPassword(MD5Util.MD5( users.getPassword()));
        users.setId(UUID.randomUUID().toString().replace("-",""));
        return usersMapper.insert(users) > 0 ? true : false;
    }
}

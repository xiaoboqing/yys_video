package com.wqg.yys_service;

import com.wqg.common.md5.MD5Util;
import com.wqg.i_yys_service.IBgmService;
import com.wqg.i_yys_service.IUsersService;
import com.wqg.vo.UserVO;
import com.wqg.yys_mapper.BgmMapper;
import com.wqg.yys_mapper.UsersMapper;
import com.wqg.yys_pojo.Bgm;
import com.wqg.yys_pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

/**
 * 用户service层实现类
 */
@Service
public class BgmService implements IBgmService {

    @Autowired
    private BgmMapper bgmMapper;

    /**
     * 获取所有bgm
     * @return
     */
    @Override
    public List<Bgm> queryBgm() {
        return bgmMapper.queryBgm();
    }
}

package com.wqg.i_yys_service;

import com.wqg.vo.UserVO;
import com.wqg.yys_pojo.Bgm;
import com.wqg.yys_pojo.Users;

import java.util.List;

/**
 * 用户service层接口
 */

public interface IBgmService {

    /**
     * 获取所有bgm
     */
    List<Bgm> queryBgm();
}

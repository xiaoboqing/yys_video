package com.wqg.api;

import com.wqg.common.ret.RetResponse;
import com.wqg.common.ret.RetResult;
import com.wqg.i_yys_service.IBgmService;
import com.wqg.yys_pojo.Bgm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 视频bgm控制层
 */
@RestController
@RequestMapping("bgm")
public class BgmController {

    @Autowired
    private IBgmService iBgmService;
    /**
     * 获取所有bgm列表
     * @return
     */
    @RequestMapping("/findAll")
    public RetResult findAllBgm() {

        try {

            List<Bgm> bgmList = iBgmService.queryBgm();
            return RetResponse.makeOKRsp(bgmList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RetResponse.makeRsp(400,"未找到bgm");

    }
}

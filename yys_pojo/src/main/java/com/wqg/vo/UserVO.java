package com.wqg.vo;

import com.wqg.yys_pojo.Users;
import lombok.Data;

@Data
public class UserVO  {

    private String id;
    private String username;
    private String faceImage;
    private String nickname;
    private Integer fansCounts;
    private Integer followCounts;
    private Integer receiveLikeCounts;

}

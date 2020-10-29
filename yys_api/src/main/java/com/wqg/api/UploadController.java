package com.wqg.api;

import com.wqg.common.ret.RetResponse;
import com.wqg.common.ret.RetResult;
import com.wqg.yys_pojo.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;

/**
 * 上传视频控制层
 */
@RestController
@RequestMapping("upload")
@Api(value = "用户文件上传接口")
public class UploadController {

    /**
     * 上传文件
     * @return
     */
    @ApiOperation(value = "上传文件 ", notes = "用户文件上传")
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public RetResult uploadVideo (@ApiParam(value = "文件上传", required = true) MultipartFile files) {



        String fileName = null;
        String dbFilePatch = null;
        String localhostFilePatch = null;
        String dirFilePatch = null;

        try {
            //获取上传图片的名称
            fileName = files.getOriginalFilename();
            dbFilePatch = "/face/" + fileName;
            localhostFilePatch = "F:/MyFile/QQ/yys_face";
            dirFilePatch = localhostFilePatch + "/" + dbFilePatch;

            File file = new File(dirFilePatch);
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            files.transferTo(file);

            Users users = new Users();
            users.setFaceImage(dbFilePatch);
            return RetResponse.makeRsp(200, "更新成功");

        } catch ( Exception e) {
            e.printStackTrace();
        }
        return RetResponse.makeRsp(400, "更新失败");
    }
}

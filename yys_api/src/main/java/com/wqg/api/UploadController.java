package com.wqg.api;

import com.wqg.common.ret.RetResponse;
import com.wqg.common.ret.RetResult;
import com.wqg.yys_pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 上传视频控制层
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    /**
     * 上传视频
     * @return
     */
    @RequestMapping("/video")
    public RetResult uploadVideo (@Param("files") MultipartFile files) {



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

        } catch ( Exception e) {
            e.printStackTrace();
        }
        return RetResponse.makeRsp(400, "更新失败");
    }
}

package com.example.seller.controller;

import com.example.seller.entity.Oss;
import com.example.seller.service.OssServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class OssController {
    @Autowired
    private OssServiceImpl ossService;
    @Autowired
    private Oss oss;
    /**
     * 图片上传到OSS服务器上面
     *
     * @param file
     * @return
     */
    @PostMapping("/common/upload")
    @ResponseBody
    @ApiOperation(value = "图片上传")
    public String uploadFileOss(MultipartFile file) {
        // 判断文件
        if (file == null) {
            return "请确认上传文件不为空！";
        }
        String filename = file.getOriginalFilename();
        try {
            //注意两种方式不能混合使用 （不能上传使用OSS 下载使用本地这样会导致图片有错误）
                //进行OSS上传方式
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    // 上传到OSS
                    String uploadUrl = ossService.upLoad(newFile);
                    if (uploadUrl!=null){
                        return "success";
                    }
                }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}

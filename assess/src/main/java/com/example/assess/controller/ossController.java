package com.example.assess.controller;


import com.aliyuncs.utils.StringUtils;
import com.example.assess.entity.Oss;
import com.example.assess.service.OssServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
public class ossController {
    @Autowired
    private OssServiceImpl ossService;
    /**
     * 通过文件名下载文件 (显示图片)
     */
    @GetMapping("/common/download")
    @ResponseBody
    @ApiOperation(value = "图片上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "文件名", required = true),
    })
    public String fileDownloadOss(String fileName, HttpServletResponse response) {
        try {
            if (StringUtils.isEmpty(fileName)) {
              //  throw new BusinessException("空的文件名");
                return "空的文件名,请重新填写";
            }
//            response.setCharacterEncoding(CharsetKit.UTF8);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("image/jpeg");
            String download = ossService.download(fileName, response.getOutputStream());
            return download;
        } catch (Exception e) {
           // log.error("下载文件失败", e);
            System.out.println("下载文件失败！"+e);
        }
        return "error";
    }
}

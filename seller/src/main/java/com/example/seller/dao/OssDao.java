package com.example.seller.dao;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.example.seller.entity.Oss;
import org.springframework.stereotype.Repository;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Repository
public class OssDao {
    private String FILE_URL=null;

    public  String upLoad(File file) {
        // 判断文件
        if (file == null) {
            return null;
        }
        // 默认值为：true 是否为图片操作
        boolean isImage = true;
        // 判断所要上传的图片是否是图片，图片可以预览，其他文件不提供通过URL预览
        try {
            Image image = ImageIO.read(file);
            isImage = image == null ? false : true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        //log.info("------OSS文件上传开始--------" + file.getName());
        System.out.println("------OSS文件上传开始--------" + file.getName());
        //地址信息
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
        Oss oss=new Oss();
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(oss.getEndpoint(), oss.getAccessKeyId(),oss.getAccessKeySecret());
        //进行设置可以预览图片操作
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/jpg");
        try {
            // 判断容器是否存在,不存在就创建
            if (!ossClient.doesBucketExist(oss.getBucketName())) {
                ossClient.createBucket(oss.getBucketName());
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(oss.getBucketName());
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            String fileUrl = oss.getFileHost() + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
            if (isImage) {//如果是图片，则图片的URL为：....
                //FILE_URL = "https://" + bucketName + "." + endPoint + "/" + fileUrl;
                FILE_URL = fileUrl;
            } else {
                FILE_URL = "非图片，不可预览。文件路径为：" + fileUrl;
            }
            // 设置权限(公开读)
            ossClient.setBucketAcl(oss.getBucketName(), CannedAccessControlList.PublicRead);
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(oss.getBucketName(), fileUrl, file, objectMetadata));
            if (result != null) {
                //log.info("------OSS文件上传成功------" + fileUrl);
                System.out.println("------OSS文件上传成功------" + fileUrl);
            }
        } catch (OSSException oe) {
            //log.error(oe.getMessage());
        } catch (ClientException ce) {
            //log.error(ce.getErrorMessage());
        } finally {
            ossClient.shutdown();
        }
        return FILE_URL;
    }
}

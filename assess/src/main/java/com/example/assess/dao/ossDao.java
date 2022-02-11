package com.example.assess.dao;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.example.assess.entity.Oss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Repository
public class ossDao {

    @Autowired
    private Oss oss;

    public  String writeBytes(String filePath,OutputStream os) throws IOException {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(oss.getEndpoint(), oss.getAccessKeyId(),oss.getAccessKeySecret());
        try {
            System.out.println("------OSS文件下载请求------" + filePath);
            // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
            OSSObject object = ossClient.getObject(oss.getBucketName(), filePath);
            if (object == null) {
                throw new FileNotFoundException(filePath);
            }
            try (InputStream fis = object.getObjectContent()) {
                byte[] b = new byte[1024];
                int length;
                while ((length = fis.read(b)) > 0) {
                    os.write(b, 0, length);
                }
                System.out.println("------OSS文件下载成功------" + filePath);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (os != null) {
                try {
                    os.close();
                    // 关闭OSSClient。
                    ossClient.shutdown();
                } catch (IOException e1) {
                }
            }
        }
        return "success";
    }
}

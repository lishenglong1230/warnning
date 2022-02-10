package com.example.seller.service;

import com.example.seller.dao.OssDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OssServiceImpl {
    @Autowired
    private OssDao ossDao;
    public String upLoad(File file){
        return ossDao.upLoad(file);
    }
}

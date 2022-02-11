package com.example.assess.service;

import com.example.assess.dao.ossDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class OssServiceImpl {
    @Autowired
    private ossDao ossDao;
    public String download(String file, OutputStream os) throws IOException {
         return ossDao.writeBytes(file,os);
    }
}

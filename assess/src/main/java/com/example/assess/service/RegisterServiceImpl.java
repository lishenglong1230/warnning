package com.example.assess.service;

import com.example.assess.dao.RegisterDao;
import com.example.assess.entity.Carinfo;
import com.example.assess.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl {
    @Autowired
    private RegisterDao registerDao;

    public int userinsert(String username,String password){
        return registerDao.userInsert(new Login(username,password));
    }
}

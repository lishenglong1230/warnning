package com.example.assess.controller;

import com.example.assess.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private RegisterServiceImpl registerService;

    @PostMapping(value = "/Register")
    @ResponseBody
    public String Register(String username,String password){
        int userinsert = registerService.userinsert(username, password);
        if (userinsert>0){
            return "success";
        }
        return "error";
    }

}

package com.example.seller.controller;

import com.example.seller.entity.User;
import com.example.seller.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    //登陆
    public String login(HttpServletRequest request, HttpServletResponse response, String username, String password, String phone){
        User user=userService.findByNameAndPassword(username, Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8)));
        //System.out.println(user.getName()+user.getPasswd());
        if(user.getUsername()==null||user.getPassword()==null){
            return "error";
        }else {
            return "success";
        }
    }
    //注册
    @PostMapping(value = "/registry")
    @ResponseBody
    //@Cacheable(cacheNames = "register",key = "#username+'-'+#password+'-'+#email")
    public String  register(String username,String password,String phone){
        User user =userService.findByName(username);
        if(user.getUsername() == null){
            //personService.register(id);
            userService.insertUser(username, Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8)),phone);
            return "Y";
        }
        return "N";
    }
}

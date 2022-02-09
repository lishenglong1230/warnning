package com.example.assess.controller;
import com.example.assess.config.LoginCheck;
import com.example.assess.entity.Login;
import com.example.assess.service.RegisterServiceImpl;
import com.example.assess.util.CodeUtil;
import com.example.assess.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Demo1 控制层
 */
@Controller
public class DemoOneController {
    public  String s;
    @Autowired
    private LoginCheck loginCheck;
    @Autowired
    private RegisterServiceImpl registerService;

    @RequestMapping(value = "/demo1",method = RequestMethod.GET)
    public String aaa(){
        return "/demo1";
    }
    @RequestMapping(value = "/demo2",method = RequestMethod.GET)
    public String bbb(){
        return "/demo2";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login(){
        return "/login";
    }
    @PostMapping(value = "/login")
    @ResponseBody
    public String demo1(HttpServletRequest request, HttpServletResponse response, String username, String password) {
    /*    if (CookieUtil.getCookies(request)!=null){
            return "success";
        }*/
        CodeUtil utilCode=new CodeUtil();
         s = utilCode.verifyCode();
        int expire = 60 * 60 * 24 * 20;  //表示7天
        Login login = registerService.FindNamePasswd(username, password);
        if (login.getUsername()==null||login.getPassword()==null){
            return "error";
        }else {
            if (!loginCheck.checkCookie(request,s)){
                CookieUtil.setCookie(request, response, "username", login.getUsername(), expire);
                CookieUtil.setCookie(request, response, "password", login.getPassword(), expire);
                return "success";
            }
        }
        return "error";
    }
}

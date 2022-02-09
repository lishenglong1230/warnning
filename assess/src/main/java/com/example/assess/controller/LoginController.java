/*
package com.example.assess.controller;

import com.example.assess.config.LoginCheck;
import com.example.assess.dao.RegisterDao;
import com.example.assess.demo1.DemoOneController;
import com.example.assess.entity.Login;
import com.example.assess.service.RegisterServiceImpl;
import com.example.assess.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


*/
/**
 * SSO登录控制器
 *//*

@Controller
@RequestMapping("/sso")
public class LoginController {
    @Autowired
    private RegisterServiceImpl registerService;
    @Autowired
    private LoginCheck loginCheck;
    @Autowired
    private DemoOneController demoOneController;
    private  String s;

    public void demo(String a){
        s=a;
    }
    @PostMapping("/doLogin")
*/
/*    public ModelAndView doLogin(String username, String password, String gotoUrl, HttpServletResponse response) {

        ModelAndView mv = new ModelAndView("login_fail");
        // 校验用户名和密码
        boolean ok = LoginCheck.checkLogin(username, password);
        // 判断是否登录成功
        if (ok) {
            Cookie cookie = new Cookie(loginCheck.COOKIE_NAME, s);
            System.out.println(s);
            // 顶级域名下，所有应用都是可见的
            cookie.setPath("/");
            // 添加Cookie
            response.addCookie(cookie);
            mv.setViewName("redirect:" + gotoUrl);
        }
        return mv;
    }*//*

    */
/**
     * 跳转到登录页面
     *//*

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

}
*/

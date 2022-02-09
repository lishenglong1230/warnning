package com.example.assess.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * 登录校验工具类
 */
@Component
public class LoginCheck {
    /**
     * 校验Cookie
     *
     * @return true正确；false错误
     */
    public boolean checkCookie(HttpServletRequest request,String s) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return false;
        }
        for (Cookie cookie : cookies) {
            if (s.equals(cookie.getValue())) {
                return true;
            }
        }
        return false;
    }
}

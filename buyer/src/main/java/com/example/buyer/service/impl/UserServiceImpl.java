package com.example.buyer.service.impl;


import com.example.buyer.dao.UserMapper;
import com.example.buyer.pojo.User;
import com.example.buyer.service.UserService;
import com.example.buyer.tools.Tools;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService {
    //mapper层实例
    @Resource
    UserMapper usermapper;

    /**
     * 用户注册的方法
     */
    @Override
    public Map<String, Object> reg(String phone, String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询手机号是否被占用
        User u = usermapper.selectByPhone(phone);
        User u2 = usermapper.selectByUserName(username);
        if (u != null) {
            //手机号已经被注册
            map.put("status", "3");
            map.put("msg", "手机号已注册");
            map.put("data", u);
            return map;
        }
        if (u2 != null) {
            //用户名已经被注册
            map.put("status", "4");
            map.put("msg", "用户名已注册");
            map.put("data", u);
            return map;
        }
        //将用户信息插入到数据库中
        //获取uuid
        String id = Tools.getUUID();
        //密码加密
        //password = Tools.getMD5(password); //MD5
        password = Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        user.setUserName(username);
        user.setPassword(password);
        int i = usermapper.insertSelective(user);
        if (i >= 1) {
            //插入成功
            //将用户状态改为已激活状态
            map.put("status", "0");
            map.put("msg", "注册成功");
            map.put("data", user);
        } else {
            //插入失败
            map.put("status", "2");
            map.put("msg", "注册失败");
            map.put("data", null);
        }
        return map;
    }

    /**
     * 用户账号密码登录
     */
    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        //密码加密
        //password = Tools.getMD5(password);
        password = Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
        User u = new User();
        u.setUserName(username);
        u.setPassword(password);
        //调用mapper中的方法查询
        User user = usermapper.selectByLogin(u);
        if (user == null) {
            //用户名或密码错误
            map.put("status", "1");
            map.put("msg", "用户名或密码错误");
            map.put("data", null);
        } else {
            map.put("status", "0");
            map.put("msg", "登录成功");
            map.put("data", user);
        }
        return map;
    }


    /**
     * 用户修改个人信息
     */
    @Override
    public Map<String, Object> changeUserinfo(String id, String username, String phone) {
        Map<String, Object> map = new HashMap<>();
        //调用mapper的方法修改信息
        User u = new User();
        u.setId(id);
        u.setUserName(username);
        u.setPhone(phone);
        int i = usermapper.updateByPrimaryKeySelective(u);
        if (i >= 1) {
            //修改成功
            //查询用户信息
            User user = usermapper.selectByPrimaryKey(id);
            map.put("status", "0");
            map.put("msg", "修改成功");
            map.put("data", user);
        } else {
            //修改失败
            map.put("status", "1");
            map.put("msg", "修改失败");
            map.put("data", null);
        }
        return map;
    }

    /**
     * 用户修改密码(status 0成功 1失败 2原密码错误)
     */
    @Override
    public Map<String, Object> modifyPassword(String id, String oldpassword, String newpassword) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查看原密码是否输入正确
        //密码加密
        //oldpassword=Tools.getMD5(oldpassword);
        //newpassword=Tools.getMD5(newpassword);
        oldpassword = Base64.getEncoder().encodeToString(oldpassword.getBytes(StandardCharsets.UTF_8));
        newpassword = Base64.getEncoder().encodeToString(newpassword.getBytes(StandardCharsets.UTF_8));

        User u = new User();
        u.setId(id);
        u.setPassword(oldpassword);
        User use = usermapper.selectByIdAndPassword(u);
        if (use == null) {
            //密码错误
            map.put("status", "2");
            map.put("msg", "原密码输入错误");
            map.put("data", null);
            return map;
        }
        //原密码正确,修改密码
        User user = new User();
        user.setId(id);
        user.setPassword(newpassword);
        int i = usermapper.updatePassword(user);
        if (i >= 1) {
            //修改成功
            map.put("status", "0");
            map.put("msg", "修改成功");
            map.put("data", null);
        } else {
            //修改失败
            map.put("status", "1");
            map.put("msg", "修改失败");
            map.put("data", null);
        }
        return map;
    }


}

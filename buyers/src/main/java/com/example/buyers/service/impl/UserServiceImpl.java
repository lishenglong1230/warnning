package com.example.buyers.service.impl;


import com.example.buyers.dao.UserMapper;
import com.example.buyers.pojo.User;
import com.example.buyers.service.UserService;
import com.example.buyers.tools.Tools;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    public Map<String, Object> reg(String phone,String name,String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询手机号是否被占用
        User u = usermapper.selectByPhone(phone);
        User u2 = usermapper.selectByName(name);
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
        password = Tools.getMD5(password);
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        user.setName(name);
        user.setPassword(password);
        int i = usermapper.insertSelective(user);
        if (i >= 1) {
            //插入成功
            //将用户状态改为已激活状态
            User use = new User();
            use.setPhone(phone);
            user.setName(name);
            use.setStatus(0);
            usermapper.updateByPhone(use);
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
    public Map<String, Object> login(String name, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        //密码加密
        password = Tools.getMD5(password);
        User u = new User();
        u.setName(name);
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

    @Override
    public Map<String, Object> loginByPhone(String phone) {
        return null;
    }


    @Override
    public Map<String, Object> changeUserinfo(String id, String name, String sex) {
        return null;
    }

    @Override
    public Map<String, Object> modifyPassword(String id, String oldpassword, String newpassword) {
        return null;
    }


}

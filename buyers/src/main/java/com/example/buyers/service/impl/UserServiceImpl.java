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
    //mapper��ʵ��
    @Resource
    UserMapper usermapper;

    /**
     * �û�ע��ķ���
     */
    @Override
    public Map<String, Object> reg(String phone,String name,String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        //��ѯ�ֻ����Ƿ�ռ��
        User u = usermapper.selectByPhone(phone);
        User u2 = usermapper.selectByName(name);
        if (u != null) {
            //�ֻ����Ѿ���ע��
            map.put("status", "3");
            map.put("msg", "�ֻ�����ע��");
            map.put("data", u);
            return map;
        }
        if (u2 != null) {
            //�û����Ѿ���ע��
            map.put("status", "4");
            map.put("msg", "�û�����ע��");
            map.put("data", u);
            return map;
        }
        //���û���Ϣ���뵽���ݿ���
        //��ȡuuid
        String id = Tools.getUUID();
        //�������
        password = Tools.getMD5(password);
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        user.setName(name);
        user.setPassword(password);
        int i = usermapper.insertSelective(user);
        if (i >= 1) {
            //����ɹ�
            //���û�״̬��Ϊ�Ѽ���״̬
            User use = new User();
            use.setPhone(phone);
            user.setName(name);
            use.setStatus(0);
            usermapper.updateByPhone(use);
            map.put("status", "0");
            map.put("msg", "ע��ɹ�");
            map.put("data", user);
        } else {
            //����ʧ��
            map.put("status", "2");
            map.put("msg", "ע��ʧ��");
            map.put("data", null);
        }
        return map;
    }

    /**
     * �û��˺������¼
     */
    @Override
    public Map<String, Object> login(String name, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        //�������
        password = Tools.getMD5(password);
        User u = new User();
        u.setName(name);
        u.setPassword(password);
        //����mapper�еķ�����ѯ
        User user = usermapper.selectByLogin(u);
        if (user == null) {
            //�û������������
            map.put("status", "1");
            map.put("msg", "�û������������");
            map.put("data", null);
        } else {
            map.put("status", "0");
            map.put("msg", "��¼�ɹ�");
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

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
    //mapper��ʵ��
    @Resource
    UserMapper usermapper;

    /**
     * �û�ע��ķ���
     */
    @Override
    public Map<String, Object> reg(String phone, String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        //��ѯ�ֻ����Ƿ�ռ��
        User u = usermapper.selectByPhone(phone);
        User u2 = usermapper.selectByUserName(username);
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
        //password = Tools.getMD5(password); //MD5
        password = Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        user.setUserName(username);
        user.setPassword(password);
        int i = usermapper.insertSelective(user);
        if (i >= 1) {
            //����ɹ�
            //���û�״̬��Ϊ�Ѽ���״̬
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
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        //�������
        //password = Tools.getMD5(password);
        password = Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
        User u = new User();
        u.setUserName(username);
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


    /**
     * �û��޸ĸ�����Ϣ
     */
    @Override
    public Map<String, Object> changeUserinfo(String id, String username, String phone) {
        Map<String, Object> map = new HashMap<>();
        //����mapper�ķ����޸���Ϣ
        User u = new User();
        u.setId(id);
        u.setUserName(username);
        u.setPhone(phone);
        int i = usermapper.updateByPrimaryKeySelective(u);
        if (i >= 1) {
            //�޸ĳɹ�
            //��ѯ�û���Ϣ
            User user = usermapper.selectByPrimaryKey(id);
            map.put("status", "0");
            map.put("msg", "�޸ĳɹ�");
            map.put("data", user);
        } else {
            //�޸�ʧ��
            map.put("status", "1");
            map.put("msg", "�޸�ʧ��");
            map.put("data", null);
        }
        return map;
    }

    /**
     * �û��޸�����(status 0�ɹ� 1ʧ�� 2ԭ�������)
     */
    @Override
    public Map<String, Object> modifyPassword(String id, String oldpassword, String newpassword) {
        Map<String, Object> map = new HashMap<String, Object>();
        //�鿴ԭ�����Ƿ�������ȷ
        //�������
        //oldpassword=Tools.getMD5(oldpassword);
        //newpassword=Tools.getMD5(newpassword);
        oldpassword = Base64.getEncoder().encodeToString(oldpassword.getBytes(StandardCharsets.UTF_8));
        newpassword = Base64.getEncoder().encodeToString(newpassword.getBytes(StandardCharsets.UTF_8));

        User u = new User();
        u.setId(id);
        u.setPassword(oldpassword);
        User use = usermapper.selectByIdAndPassword(u);
        if (use == null) {
            //�������
            map.put("status", "2");
            map.put("msg", "ԭ�����������");
            map.put("data", null);
            return map;
        }
        //ԭ������ȷ,�޸�����
        User user = new User();
        user.setId(id);
        user.setPassword(newpassword);
        int i = usermapper.updatePassword(user);
        if (i >= 1) {
            //�޸ĳɹ�
            map.put("status", "0");
            map.put("msg", "�޸ĳɹ�");
            map.put("data", null);
        } else {
            //�޸�ʧ��
            map.put("status", "1");
            map.put("msg", "�޸�ʧ��");
            map.put("data", null);
        }
        return map;
    }


}

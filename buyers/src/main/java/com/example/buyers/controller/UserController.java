package com.example.buyers.controller;

import com.example.buyers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Resource(name = "userServiceImpl")
    UserService uservice;

    //�洢��֤��
    //private String phoneCode;

    /**
     * �û�ע���ȡ��֤��status(0 �ɹ�)
     * @param phone ע����ֻ���
     * @return
     */
	/*@ResponseBody
	@RequestMapping("user_getcode")
	public Map<String,Object> getCode(String phone){
		Map<String,Object> map=new HashMap<String, Object>();
		//��ȡ��֤��
		phoneCode=PhoneCode.getCode();
		//���Ͷ���
		PhoneCode.sendCode(phone, phoneCode);
		System.out.println("���ɵĶ�����֤��:"+phoneCode);
		map.put("status", "0");
		return map;
	}*/

    /**
     * �û�ע��status(0�ɹ� 1��֤����� 2ע��ʧ�� 3�ֻ�����ע�� 4�û�����ע��)
     *
     * @param phone    ע����ֻ���
     * @param name     ע����û���
     * @param password �û����������
     * @return
     */
    @RequestMapping("user_reg")
    @ResponseBody
    public Map<String, Object> reg(String phone, String name, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
		/*if(!phoneCode.equals(code)){
			//��֤�����
			map.put("status","1");
			map.put("msg", "��֤�����");
			map.put("data", null);
			return map;
		}else{
			//��֤����ȷ,�����߼���洢����
			return uservice.reg(phone, password);
		}*/
        return uservice.reg(phone, name, password);
    }

    /**
     * �û���¼�ķ���
     *
     * @param name
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("user_login")
    @ResponseBody
    public Map<String, Object> login(String name, String password, HttpSession session) {
        //����ʵ�ֲ�ķ���
        Map<String, Object> map = uservice.login(name, password);
        //System.out.println(map.get("status"));
        //System.out.println(map.get("msg"));
        session.setAttribute("user", map);
//		if("0".equals(map.get("status"))){
//			return "index";
//		}
        return map;
    }

}

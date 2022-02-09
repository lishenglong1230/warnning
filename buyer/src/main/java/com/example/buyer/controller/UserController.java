package com.example.buyer.controller;

import com.example.buyer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
     * @param username ע����û���
     * @param password �û����������
     * @return
     */
    @RequestMapping("user_reg")
    @ResponseBody
    public Map<String, Object> reg(String phone, String username, String password) {
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
        return uservice.reg(phone, username, password);
    }

    /**
     * �û���¼�ķ���
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("user_login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpSession session) {
        //����ʵ�ֲ�ķ���
        Map<String, Object> map = uservice.login(username, password);
        //System.out.println(map.get("status"));
        //System.out.println(map.get("msg"));
        session.setAttribute("user", map);
//		if("0".equals(map.get("status"))){
//			return "index";
//		}
        return map;
    }

    /**
     * �û���ȫ�˳��ķ���
     *
     * @param session
     * @return
     */
    @RequestMapping("user_logout")
    @ResponseBody
    public ModelAndView logout(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        //���session�е�ֵ
        session.invalidate();
        mv.setViewName("index");
        return mv;
    }

    /**
     * �޸��û���Ϣ�ķ���
     *
     * @param id
     * @param username
     * @param session
     * @return
     */
    @RequestMapping("user_modifyuserinfo")
    @ResponseBody
    public Map<String, Object> modifyUserinfo(String id, String username, String phone, HttpSession session) {
        //Map<String,Object> map=new HashMap<>();
        //System.out.println(id);
        //System.out.println(username);
        //System.out.println(sex);
        //����ҵ��㽫�޸ĵ����ݴ������ݿ�
        Map<String, Object> map = uservice.changeUserinfo(id, username, phone);
        if ("0".equals(map.get("status"))) {
            //�ɹ�
            session.setAttribute("user", map);
        }
        return map;
    }

    /**
     * �û��޸�����
     * @param id �û�id
     * @param oldpassword ԭ����
     * @param newpassword ������
     * @return
     */
    @RequestMapping("changpassword")
    @ResponseBody
    public Map<String,Object> modifyPassword(String id,String oldpassword,String newpassword){
        System.out.println(id);
        System.out.println(oldpassword);
        System.out.println(newpassword);
        return uservice.modifyPassword(id, oldpassword, newpassword);
    }

}

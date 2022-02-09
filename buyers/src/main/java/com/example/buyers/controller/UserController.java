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

    //存储验证码
    //private String phoneCode;

    /**
     * 用户注册获取验证码status(0 成功)
     * @param phone 注册的手机号
     * @return
     */
	/*@ResponseBody
	@RequestMapping("user_getcode")
	public Map<String,Object> getCode(String phone){
		Map<String,Object> map=new HashMap<String, Object>();
		//获取验证码
		phoneCode=PhoneCode.getCode();
		//发送短信
		PhoneCode.sendCode(phone, phoneCode);
		System.out.println("生成的短信验证码:"+phoneCode);
		map.put("status", "0");
		return map;
	}*/

    /**
     * 用户注册status(0成功 1验证码错误 2注册失败 3手机号已注册 4用户名已注册)
     *
     * @param phone    注册的手机号
     * @param name     注册的用户名
     * @param password 用户输入的密码
     * @return
     */
    @RequestMapping("user_reg")
    @ResponseBody
    public Map<String, Object> reg(String phone, String name, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
		/*if(!phoneCode.equals(code)){
			//验证码错误
			map.put("status","1");
			map.put("msg", "验证码错误");
			map.put("data", null);
			return map;
		}else{
			//验证码正确,调用逻辑层存储数据
			return uservice.reg(phone, password);
		}*/
        return uservice.reg(phone, name, password);
    }

    /**
     * 用户登录的方法
     *
     * @param name
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("user_login")
    @ResponseBody
    public Map<String, Object> login(String name, String password, HttpSession session) {
        //调用实现层的方法
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

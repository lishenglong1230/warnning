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
     * @param username 注册的用户名
     * @param password 用户输入的密码
     * @return
     */
    @RequestMapping("user_reg")
    @ResponseBody
    public Map<String, Object> reg(String phone, String username, String password) {
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
        return uservice.reg(phone, username, password);
    }

    /**
     * 用户登录的方法
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("user_login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpSession session) {
        //调用实现层的方法
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
     * 用户安全退出的方法
     *
     * @param session
     * @return
     */
    @RequestMapping("user_logout")
    @ResponseBody
    public ModelAndView logout(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        //清空session中的值
        session.invalidate();
        mv.setViewName("index");
        return mv;
    }

    /**
     * 修改用户信息的方法
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
        //调用业务层将修改的数据存入数据库
        Map<String, Object> map = uservice.changeUserinfo(id, username, phone);
        if ("0".equals(map.get("status"))) {
            //成功
            session.setAttribute("user", map);
        }
        return map;
    }

    /**
     * 用户修改密码
     * @param id 用户id
     * @param oldpassword 原密码
     * @param newpassword 新密码
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

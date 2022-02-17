package com.example.buyer.controller;

import com.example.buyer.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AddressController {
	
	@Resource(name="addressServiceImpl")
	AddressService aservice;
	
	/**
	 * 用户添加收货地址
	 * @param uid 用户id
	 * @param adduser 收货人名
	 * @param phone 收货人手机号
	 * @param detailadd 详细地址
	 * @return
	 */
	@RequestMapping("address_add")
	@ResponseBody
	public ModelAndView addAddress(String uid, String adduser, String phone, String detailadd, HttpSession session){
		ModelAndView mav=new ModelAndView();
		//调用业务层
		Map<String,Object> map=aservice.addAddress(uid, adduser, phone, detailadd);
		session.setAttribute("address", map);
		
		if("2".equals(map.get("status"))){
			//达到上限 防止重复地址
			mav.addObject("code", map.get("status"));
		}
		mav.setViewName("address");
		return mav;
	}
	
	/**
	 * 进入到地址管理界面初始化所有地址信息
	 * @param uid 用户id
	 * @return
	 */
	@RequestMapping("addressAll")
	@ResponseBody
	public ModelAndView addressAll(String uid){
		ModelAndView mav=new ModelAndView();
		//调用业务层查询所有地址信息
		Map<String,Object> map=aservice.addressAll(uid);
		mav.setViewName("address");
		mav.addObject("address", map);
		return mav;
	}
	
	/**
	 * 修改默认地址的方法
	 * @param id 地址id
	 * @param uid 用户id
	 * @return
	 */
	@RequestMapping("address_changeDefault")
	@ResponseBody
	public Map<String,Object> modifyDefaultAddress(String id,String uid){
		//调用业务层修改状态
		Map<String,Object> map=aservice.modifyDefaultAddress(id, uid);
		return map;
	}
	
	/**
	 * 删除地址
	 * @param id 地址id
	 * @param uid 用户id
	 * @return
	 */
	@RequestMapping("address_del")
	@ResponseBody
	public Map<String,Object> delAddress(String id,String uid){
		//调用业务层
		//addressAll(uid);
		return aservice.delAddress(id, uid);
	}
	
	
	
}

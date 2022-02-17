package com.example.buyer.controller;

import com.example.buyer.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CarsController {

    @Resource(name = "carsServiceImpl")
    CarService carService;

    /**
     * �鿴������ϸ��Ϣ
     *
     * @param id
     * @return
     */

    @RequestMapping("cars_xiangqing")
    @ResponseBody
    public Map<String, Object> xiangqing(String id) {
        //ModelAndView mav=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        Map<String, Object> carmap = carService.carsinfo(id);
        //mav.addObject("cars", map);
        //mav.setViewName("xiangqing");
        map.put("cars",carmap);
        return map;
    }

    /**
     * ��ѯ���������б�
     *
     * @return
     */
    @RequestMapping("cars_list")
    @ResponseBody
    public ModelAndView carsList() {
        ModelAndView mav = new ModelAndView();
        //���÷���㣬��ѯ������Ʒ
        Map<String, Object> map = carService.carsList();
//		System.out.println(map.get("status"));
//		System.out.println(map.get("msg"));
//		System.out.println(map.get("data"));
        if ("0".equals(map.get("status"))) {
            //�ɹ�
            mav.setViewName("list");
            mav.addObject("status", "0");
            mav.addObject("carslist", map);
        } else {
            mav.setViewName("list");
            mav.addObject("status", "1");
            mav.addObject("carslist", map);
        }
        return mav;
    }

    /**
     * ������Ʒ(ģ����ѯ)
     *
     * @param brand
     * @return
     */
    @RequestMapping("selectCars")
    @ResponseBody
    public ModelAndView searchCars(String brand) {
        ModelAndView mav = new ModelAndView();
        //����ҵ���ģ����ѯ
        Map<String, Object> map = carService.searchForCars(brand);
        mav.setViewName("list");
        mav.addObject("carslist", map);
        return mav;
    }


}

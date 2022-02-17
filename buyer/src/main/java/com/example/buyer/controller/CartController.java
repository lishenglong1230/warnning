package com.example.buyer.controller;

import com.example.buyer.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {

    @Resource(name = "cartServiceImpl")
    CartService cartservice;

    /**
     * 将商品添加到收藏夹
     *
     * @param uid     用户id
     * @param gid     商品id
     * @param session
     * @return
     */
    @RequestMapping("addcart")
    @ResponseBody
    public Map<String, Object> addCart(String uid, String gid, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        //将结果存入到session中
        session.setAttribute("carscart", map);
        return cartservice.addCart(uid, gid);
    }

    /**
     * 点击购物车，加载所有收藏夹中的商品
     *
     * @param uid 用户id
     * @return
     */
    @RequestMapping("carscartAll")
    public ModelAndView carsCarAll(String uid, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        //调用业务层查询所有商品
        Map<String, Object> map = cartservice.cartAll(uid);
        mav.setViewName("shoppingCar");
        session.setAttribute("carscart", map);
        //mav.addObject("carscart",map);
        return mav;
    }

    /**
     * 用户从购物车中删除商品
     *
     * @param uid 用户id
     * @param gid 商品id
     * @return
     */
    @RequestMapping("delcars")
    public ModelAndView delCartCars(String uid, String gid, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        //调用业务层删除商品
        Map<String, Object> map = cartservice.delCars(uid, gid);
        session.setAttribute("carscart", map);
        mav.setViewName("shoppingCar");
        return mav;
    }

    /**
     * 用户进入到确认订单页面
     *
     * @param uid
     * @param gids
     * @param sumprice
     * @return
     */
    @RequestMapping("affirmOrder")
    @ResponseBody
    public ModelAndView affirmOrder(String uid, String gids, String sumprice, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        System.out.println(gids);
        //调用业务层
        Map<String, Object> map = cartservice.affirmBuy(uid, gids, sumprice);
        //将数据存入session中
        session.setAttribute("affirmAddress", map.get("addressList"));//地址
        session.setAttribute("cartItemList", map.get("cartItemList"));//购买的商品
        System.out.println(map.get("cartItemList"));
        mav.setViewName("affirm");
        mav.addObject("sumprice", sumprice);
        return mav;
    }


}

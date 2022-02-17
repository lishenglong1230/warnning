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
     * ����Ʒ��ӵ��ղؼ�
     *
     * @param uid     �û�id
     * @param gid     ��Ʒid
     * @param session
     * @return
     */
    @RequestMapping("addcart")
    @ResponseBody
    public Map<String, Object> addCart(String uid, String gid, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        //��������뵽session��
        session.setAttribute("carscart", map);
        return cartservice.addCart(uid, gid);
    }

    /**
     * ������ﳵ�����������ղؼ��е���Ʒ
     *
     * @param uid �û�id
     * @return
     */
    @RequestMapping("carscartAll")
    public ModelAndView carsCarAll(String uid, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        //����ҵ����ѯ������Ʒ
        Map<String, Object> map = cartservice.cartAll(uid);
        mav.setViewName("shoppingCar");
        session.setAttribute("carscart", map);
        //mav.addObject("carscart",map);
        return mav;
    }

    /**
     * �û��ӹ��ﳵ��ɾ����Ʒ
     *
     * @param uid �û�id
     * @param gid ��Ʒid
     * @return
     */
    @RequestMapping("delcars")
    public ModelAndView delCartCars(String uid, String gid, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        //����ҵ���ɾ����Ʒ
        Map<String, Object> map = cartservice.delCars(uid, gid);
        session.setAttribute("carscart", map);
        mav.setViewName("shoppingCar");
        return mav;
    }

    /**
     * �û����뵽ȷ�϶���ҳ��
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
        //����ҵ���
        Map<String, Object> map = cartservice.affirmBuy(uid, gids, sumprice);
        //�����ݴ���session��
        session.setAttribute("affirmAddress", map.get("addressList"));//��ַ
        session.setAttribute("cartItemList", map.get("cartItemList"));//�������Ʒ
        System.out.println(map.get("cartItemList"));
        mav.setViewName("affirm");
        mav.addObject("sumprice", sumprice);
        return mav;
    }


}

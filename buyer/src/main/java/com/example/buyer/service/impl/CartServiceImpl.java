package com.example.buyer.service.impl;

import com.example.buyer.dao.AddressMapper;
import com.example.buyer.dao.CarMapper;
import com.example.buyer.dao.CartMapper;
import com.example.buyer.pojo.Address;
import com.example.buyer.pojo.Car;
import com.example.buyer.pojo.Cart;
import com.example.buyer.service.CartService;
import com.example.buyer.tools.Tools;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("cartServiceImpl")
public class CartServiceImpl implements CartService {

	@Resource
    CartMapper cartmapper;

	@Resource
    AddressMapper addressmapper;

	@Resource
    CarMapper carMapper;

	/**
	 * ��ӵ����ﳵ
	 */
	@Override
	public Map<String, Object> addCart(String uid, String gid) {
		Map<String, Object> map =new HashMap<String, Object>();
		//�����ж��û��Ƿ��Ѿ���ӵ����ﳵ
		Cart cart=new Cart();
		cart.setUid(uid);
		cart.setGid(gid);
		Cart c=cartmapper.selectByUidAndGid(cart);
		if(c!=null){
			//�Ѿ���ӹ��ˣ����޸ĸ���Ʒ������
			Cart updatecart=new Cart();
			updatecart.setId(c.getId());//���ݲ�ѯ������Ʒid�޸�
			cartmapper.updateByPrimaryKeySelective(updatecart);//�޸�
			map.put("status", "0");
			map.put("msg", "��ӳɹ�");
			map.put("data", null);
			return map;
		}
		//������Ʒid��ѯ��Ʒ��ϸ��Ϣ
		Car car=carMapper.selectByPrimaryKey(gid);
		//�������ﳵ����
		Cart cart1=new Cart();
		cart1.setId(Tools.getUUID());
		cart1.setGid(gid);
		cart1.setUid(uid);
		cart1.setGoodsname(car.getBrand());
		cart1.setPrice(Double.parseDouble(car.getRate()));
		//����Ʒ��Ŀ��ӵ����ﳵ����
		int i=cartmapper.insert(cart);
		if(i>=1){
			//�ɹ�
			map.put("status", "0");
			map.put("msg", "��ӳɹ�");
			map.put("data", null);
		}else{
			//ʧ��
			map.put("status", "1");
			map.put("msg", "���ʧ��");
			map.put("data", null);
		}
		return map;
	}


	/**
	 * ��ѯ�û����ﳵ�е�������Ʒ
	 */
	@Override
	public Map<String, Object> cartAll(String uid) {
		Map<String, Object> map=new HashMap<String,Object>();
		//����mapper���ѯ
		List<Cart> list=cartmapper.selectByuid(uid);
		map.put("status", "0");
		map.put("msg", "��ѯ�ɹ�");
		map.put("data",list);
		return map;
	}


	/**
	 * �û��ӹ��ﳵ��ɾ����Ʒ
	 */
	@Override
	public Map<String, Object> delCars(String uid, String gid) {
		Map<String, Object> map=new HashMap<String,Object>();
		//����mapper�ķ���
		Cart cart=new Cart();
		cart.setUid(uid);
		cart.setGid(gid);
		int i=cartmapper.updateByUidAndGid(cart);
		if(i>=1){
			//ɾ���ɹ�
			//�����û�id��ѯ���й��ﳵ�е���Ʒ
			List<Cart> list=cartmapper.selectByuid(uid);
			map.put("status", "0");
			map.put("msg", "ɾ���ɹ�");
			map.put("data", list);
		}else{
			//ɾ��ʧ��
			map.put("status", "1");
			map.put("msg", "ɾ��ʧ��");
			map.put("data", null);
		}
		return map;
	}

	/**
	 * ��ѯ�û�ȷ�Ϲ���Ķ�����
	 */
	@Override
	public Map<String, Object> affirmBuy(String uid, String gids, String sumprice) {
		Map<String, Object> map=new HashMap<String,Object>();
		//��ȡ��Ʒid����
		String ids[]=gids.split("~");
		//����һ�����ﳵ���
		List<Cart> cartItemList=new ArrayList<Cart>();
		for (String str : ids) {
			//������Ʒid��ѯ��Ʒ��Ϣ(�ӹ��ﳵ����)
			//System.out.println(str);
			Cart car=cartmapper.selectByPrimaryKey(str);
			cartItemList.add(car);//����ȷ�Ϲ������Ʒ
			//��ȷ�Ϲ������Ʒ�ӹ��ﳵ����ɾ��(״̬����Ϊ1)
			Cart cart=new Cart();
			cart.setId(str);
			cartmapper.updateByPrimaryKeySelective(cart);
		}
		//�����û�id��ѯ�û��ĵ�ַ
		List<Address> addressList=addressmapper.selectAddressAll(uid);
		map.put("status", "0");
		map.put("msg", "��ѯ�ɹ�");
		map.put("cartItemList", cartItemList);
		map.put("addressList", addressList);
		return map;
	}
	
	
	
	
	
	
	
}

package com.example.buyer.dao.dao;

import com.example.buyer.pojo.User;

public interface UserMapper {
	//ͨ��idɾ��
    int deleteByPrimaryKey( String id);

    //��������
    int insert(User record);

    //���벿������
    int insertSelective(User record);

    //ͨ��id��ѯ
    User selectByPrimaryKey(String id);

    //ͨ��id�޸Ĳ�����Ϣ
    int updateByPrimaryKeySelective(User record);
    
    //ͨ��id�޸�������Ϣ
    int updateByPrimaryKey(User record);
    
    //��ѯ�ֻ����Ƿ�ռ��
    User selectByPhone(String phone);

    //��ѯ�û����Ƿ�ռ��
    User selectByUserName(String username);

    //�û���¼ �����ֻ��ź������ѯ
    User selectByLogin(User user);
    
    //�޸��û���¼״̬
    int updateByPhone(User user);
    
    //����id���û������ѯ�û�
    User selectByIdAndPassword(User user);
    
    //����id�޸�����
    int updatePassword(User user);
    
    
    
}
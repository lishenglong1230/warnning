package com.example.seller.service;


import com.example.seller.entity.User;

public interface UserService {
    /**
     * 新增一个用户
     *
     */
    int create(String username,String Password,String phone);


  /**
     * 根据name删除一个用户高
     * @param username
     */
    void deleteByName(String username);

    /**
     * 通过用户名判断是否添加用户
     */
    User findByName(String name);
    /**
     *判断数据库是否存在用户名和密码
     */
    User findByNameAndPassword(String username,String password);



}

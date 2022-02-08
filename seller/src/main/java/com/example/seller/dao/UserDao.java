package com.example.seller.dao;

import com.example.seller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(String username,String password) {
        return jdbcTemplate.update("insert into user(username,password)values (?,?)",username,password);
    }

    @Override
    public void deleteByName(String username) {
        jdbcTemplate.update("delete from user where username = ?", username);
    }


}
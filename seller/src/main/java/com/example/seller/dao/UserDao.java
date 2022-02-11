package com.example.seller.dao;

import com.example.seller.entity.User;
import com.example.seller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(String username,String password,String phone) {
        return jdbcTemplate.update("insert into login(username,password,phone)values (?,?,?)",username,password,phone);
    }

    @Override
    public void deleteByName(String username) {
         jdbcTemplate.update("delete from login where username = ?", username);
    }

    public User findByName(String name) {
        final User user = new User();
        String sql = "SELECT username FROM login WHERE username=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUsername(resultSet.getString(1));
            }
        });
        return user;
    }

    @Override
    public User findByNameAndPassword(String username, String password) {
        final User user = new User();
        String sql = "SELECT * FROM login WHERE username=? AND password=?";
        jdbcTemplate.query(sql, new Object[]{username, password}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
        });
        return user;
    }

}
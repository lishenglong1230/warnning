package com.example.assess.dao;

import com.example.assess.entity.Carinfo;
import com.example.assess.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RegisterDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public  int userInsert(Login login){
        String sql="INSERT INTO login(username,password)VALUES(?,?)";
        return jdbcTemplate.update(sql,login.getUsername(),login.getPassword());
    }


    public Login findByNameAndPassword(String username, String password) {
        final Login user = new Login();
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

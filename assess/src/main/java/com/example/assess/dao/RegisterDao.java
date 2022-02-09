package com.example.assess.dao;

import com.example.assess.entity.Carinfo;
import com.example.assess.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public  int userInsert(Login login){
        String sql="INSERT INTO carinfo(username,password)VALUES(?,?)";
        return jdbcTemplate.update(sql,login.getUsername(),login.getPassword());
    }
}

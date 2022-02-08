package com.example.assess.dao;

import com.example.assess.entity.Carinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AssessmentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

/*数据插入*/
    public  int AssessmentInsert(Carinfo carinfo){
        String sql="INSERT INTO Carinfo(coty,mileage,national,gearbox,displacement,drive,fuel,allocation,seat,date)VALUES(?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,carinfo.getCoty(),carinfo.getMileage(),carinfo.getNational(),
                carinfo.getGearbox(),carinfo.getDisplacement(),carinfo.getDrive(),carinfo.getFuel(),carinfo.getAllocation(),carinfo.getSeat(),carinfo.getDate());
    }
}

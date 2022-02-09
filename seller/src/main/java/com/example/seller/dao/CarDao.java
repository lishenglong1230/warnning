package com.example.seller.dao;

import com.example.seller.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao implements CarService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int insertCar(String brand,String series,String rate,String model,String colour,String place){
        return jdbcTemplate.update("insert into (brand,series,rate,model,colour,place)values (?,?,?,?,?,?)",brand,series,rate,model,colour,place);
    }
    public int insertCarInfo(String coty,String mileage,String national,String gearbox,String displacement,String drive,String fuel,String allocation,String seat,String date){
        return jdbcTemplate.update("insert into (coty,mileage,national,gearbox,displacement,drive,fuel,allocation,seat,date)values (?,?,?,?,?,?,?,?,?,?)",coty,mileage,national,gearbox,displacement,drive,fuel,allocation,seat,date);
    }
}

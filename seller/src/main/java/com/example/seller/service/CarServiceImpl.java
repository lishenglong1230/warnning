package com.example.seller.service;

import com.example.seller.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl {
    @Autowired
    private CarDao carDao;

    public int insertCar(String brand,String series,String rate,String model,String colour,String place,String phone){
        return carDao.insertCar(brand,series,rate,model,colour,place,phone);
    }

    public int insertCarInfo(String coty,String mileage,String national,String gearbox,String displacement,String drive,String fuel,String allocation,String seat,String date){
        return carDao.insertCarInfo(coty,mileage,national,gearbox,displacement,drive,fuel,allocation,seat,date);
    }
}

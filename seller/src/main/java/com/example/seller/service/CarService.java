package com.example.seller.service;

public interface CarService {
    /**
     * 添加车信息
     * @param brand
     * @param series
     * @param rate
     * @param model
     * @param colour
     * @param place
     * @param phone
     * @return
     */
    int insertCar(String brand,String series,String rate,String model,String colour,String place,String phone);

    /**
     * 添加车详细信息
     * @param coty
     * @param mileage
     * @param national
     * @param gearbox
     * @param displacement
     * @param drive
     * @param fuel
     * @param allocation
     * @param seat
     * @param date
     * @return
     */
    int insertCarInfo(String coty,String mileage,String national,String gearbox,String displacement,String drive,String fuel,String allocation,String seat,String date);

}

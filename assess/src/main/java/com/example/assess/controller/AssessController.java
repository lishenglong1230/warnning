package com.example.assess.controller;

import com.example.assess.service.AssessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AssessController {
    @Autowired
    private AssessServiceImpl assessService;

    @PostMapping(value = "/car")
    @ResponseBody
    public String CarInfo(String coty,String mileage,String national,String gearbox,String displacement,String drive,String fuel,String allocation,String seat,String date){
        int i = assessService.insertAssess(coty, mileage, national, gearbox, displacement, drive, fuel, allocation, seat, date);
        if (i>0){
            return "success";
        }
        return "error";

    }
}

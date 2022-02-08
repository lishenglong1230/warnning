package com.example.assess.service;

import com.example.assess.dao.AssessmentDao;
import com.example.assess.entity.Carinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessServiceImpl {
    @Autowired
    private AssessmentDao assessmentDao;

    public int insertAssess(String coty,String mileage,String national,String gearbox,String displacement,String drive,String fuel,String allocation,String seat,String date){
        return assessmentDao.AssessmentInsert(new Carinfo(coty,mileage,national,gearbox,displacement,drive,fuel,allocation,seat,date));
    }
}

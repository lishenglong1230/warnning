package com.example.assess;

import com.example.assess.service.AssessServiceImpl;
import com.example.assess.service.RegisterServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssessApplicationTests {

    @Autowired
    private AssessServiceImpl assessService;
    @Autowired
    private RegisterServiceImpl registerService;
    @Test
    void contextLoads() {
        /*int i = assessService.insertAssess("xx", "sss", "11", "22", "eee", "sss", "fff", "rrr", "ttt", "ghhh");
        System.out.println(i);*/
        int userinsert = registerService.userinsert("1111", "44");

        System.out.println(userinsert);
    }

}

package com.example.chat;


import com.example.chat.mapper.NettyMapper;
import com.example.chat.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChatApplication {

    @Autowired
    private MessageService messageService;
    @Test
    public void test(){
        messageService.getAllMessage("119d1416", "b1cce960");
    }

}

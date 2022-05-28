package com.example.chat.service;

import com.alibaba.fastjson.JSON;
import com.example.chat.entity.Message;
import com.example.chat.mapper.NettyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private NettyMapper nettyMapper;


    @Override
    public List<Message> getAllMessage(String fromCode, String toCode) {
        return nettyMapper.getAllMessage(fromCode,toCode);
    }

    @Override
    public boolean AddMessage(Message message) {
       return nettyMapper.AddMessage(message);
    }
}

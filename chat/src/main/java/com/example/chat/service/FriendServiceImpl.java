package com.example.chat.service;

import com.example.chat.mapper.NettyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FriendServiceImpl implements FriendService{

    @Resource
    NettyMapper nettyMapper;

    @Override
    public int addFriend(String fromCode, String toCode) {
       return nettyMapper.insertFriend(fromCode,toCode);
    }
}

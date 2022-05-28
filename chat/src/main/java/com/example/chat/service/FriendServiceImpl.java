package com.example.chat.service;

import com.example.chat.entity.Friend;
import com.example.chat.entity.Message;
import com.example.chat.mapper.NettyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService{

    @Autowired
    private NettyMapper nettyMapper;

    @Override
    public int addFriend(String fromCode, String toCode) {
        return nettyMapper.addFriend(fromCode,toCode);
    }

    @Override
    public List<Friend> getAllFriend(String fromCode) {
        return nettyMapper.getAllFriend(fromCode);
    }


}

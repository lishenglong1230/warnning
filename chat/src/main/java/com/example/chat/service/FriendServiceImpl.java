package com.example.chat.service;

<<<<<<< HEAD
import com.example.chat.entity.Friend;
import com.example.chat.entity.Message;
=======
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
import com.example.chat.mapper.NettyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD

import javax.annotation.Resource;
import java.util.List;
=======
import javax.annotation.Resource;
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260

@Service
public class FriendServiceImpl implements FriendService{

<<<<<<< HEAD
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


=======
    @Resource
    NettyMapper nettyMapper;

    @Override
    public int addFriend(String fromCode, String toCode) {
       return nettyMapper.insertFriend(fromCode,toCode);
    }
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
}

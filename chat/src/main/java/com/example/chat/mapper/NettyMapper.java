package com.example.chat.mapper;

import com.example.chat.entity.Friend;
import com.example.chat.entity.Message;
import com.example.chat.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NettyMapper {

    int addFriend(String fromCode,String toCode);

    /**
     获取所有好友
     */
    List<Friend> getAllFriend(String fromCode);

    /**
     获取所有聊天信息
     */
    List<Message> getAllMessage(String fromCode,String toCode);

    /**
     插入聊天信息
     */
    boolean AddMessage(Message message);

    /**
     获取登录信息
     */
    User findPassword(User user);
}

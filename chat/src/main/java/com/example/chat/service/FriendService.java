package com.example.chat.service;

import com.example.chat.entity.Friend;
import com.example.chat.entity.Message;

import java.util.List;

public interface FriendService {

    int addFriend(String fromCode,String toCode);

    List<Friend> getAllFriend(String fromCode);


}

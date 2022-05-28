package com.example.chat.service;

import com.example.chat.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessage(String fromCode, String toCode);

    boolean AddMessage(Message message);
}

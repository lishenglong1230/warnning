package com.example.chat.controller;

import com.example.chat.entity.Message;
import com.example.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;


    @RequestMapping(value = "/getAllMessage", method = RequestMethod.GET)
    public List<Message> getAllMessage(@RequestParam String fromCode, @RequestParam String toCode) {
        List<Message> allMessage = messageService.getAllMessage(fromCode, toCode);

        return allMessage;
    }
}

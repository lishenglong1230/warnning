package com.example.chat.controller;

import com.example.chat.entity.Message;
import com.example.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

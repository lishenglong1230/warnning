package com.example.chat.controller;

import com.example.chat.entity.RestMsg;
import com.example.chat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendController {

    @Autowired
    FriendService friendService;

    @GetMapping("/addFriend")
    public RestMsg addFriend(@RequestParam String fromCode, @RequestParam String toCode){
       int status = friendService.addFriend(fromCode,toCode);
        if(status == 2){
            return RestMsg.ok("添加成功");
        }else {
            return RestMsg.fail("异常添加失败，请重试");
        }
    }
}

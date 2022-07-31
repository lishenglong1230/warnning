package com.example.chat.controller;

import com.example.chat.entity.Friend;
import com.example.chat.entity.Message;
import com.example.chat.service.FriendService;
import com.example.chat.util.ResMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FriendController {

    @Autowired
    private FriendService friendService;

    @RequestMapping(value = "/addFriend", method = RequestMethod.GET)
    public ResMsg addFriend(@RequestParam String fromCode, @RequestParam String toCode) {
        int res = friendService.addFriend(fromCode, toCode);

        if (res == 1){
            return ResMsg.ok("添加成功");
        }else {
            return ResMsg.fail("异常添加失败，请重试");
        }
    }

    @RequestMapping(value = "/getAllFriend", method = RequestMethod.GET)
    public List<Friend> getAllFriend(@RequestParam String fromCode) {
        List<Friend> allFriend = friendService.getAllFriend(fromCode);

        return allFriend;
    }


}

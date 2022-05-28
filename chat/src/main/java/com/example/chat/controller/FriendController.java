package com.example.chat.controller;

<<<<<<< HEAD
import com.example.chat.entity.Friend;
import com.example.chat.entity.Message;
import com.example.chat.service.FriendService;
import com.example.chat.util.ResMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

=======
import com.example.chat.entity.RestMsg;
import com.example.chat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
@RestController
public class FriendController {

    @Autowired
<<<<<<< HEAD
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


=======
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
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
}

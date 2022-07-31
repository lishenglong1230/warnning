package com.example.chat.entity;
import lombok.Data;
@Data
public class Message {

    //发送的消息
    private String content;
    //消息时间
    private String sendTime;
    //消息发送方
    private String fromCode;
    //消息接收方
    private String toCode;

}

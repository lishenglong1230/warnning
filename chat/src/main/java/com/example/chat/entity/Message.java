package com.example.chat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Message {


    //发送的消息
    private String content;
    //消息时间
    private String sendTime;
    //消息发送方
    private String fromCode;
    //消息接收方
    private String toCode;

//    public Message( String content, String sendTime, String fromCode, String toCode) {
//        this.content = content;
//        this.sendTime = sendTime;
//        this.fromCode = fromCode;
//        this.toCode = toCode;
//    }


    public String getFromCode() { return fromCode; }

    public void setFromCode(String fromCode) { this.fromCode = fromCode; }

    public String getToCode() { return toCode; }

    public void setToCode(String toCode) { this.toCode = toCode; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

}

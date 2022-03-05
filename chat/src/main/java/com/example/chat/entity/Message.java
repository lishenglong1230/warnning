package com.example.chat.entity;

import java.sql.Timestamp;

public class Message {


    //发送的消息
    private String content;
    //消息时间
    private String timestamp;
    //消息发送方
    private String fromCode;
    //消息接收方
    private String toCode;

    public Message( String content, String timestamp, String fromCode, String toCode) {
        this.content = content;
        this.timestamp = timestamp;
        this.fromCode = fromCode;
        this.toCode = toCode;
    }


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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}

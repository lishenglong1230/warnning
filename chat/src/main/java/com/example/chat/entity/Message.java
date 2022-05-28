package com.example.chat.entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;

=======
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
import java.sql.Timestamp;

public class Message {


    //发送的消息
    private String content;
    //消息时间
<<<<<<< HEAD
    private String sendTime;
=======
    private String timestamp;
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
    //消息发送方
    private String fromCode;
    //消息接收方
    private String toCode;

<<<<<<< HEAD
//    public Message( String content, String sendTime, String fromCode, String toCode) {
//        this.content = content;
//        this.sendTime = sendTime;
//        this.fromCode = fromCode;
//        this.toCode = toCode;
//    }
=======
    public Message( String content, String timestamp, String fromCode, String toCode) {
        this.content = content;
        this.timestamp = timestamp;
        this.fromCode = fromCode;
        this.toCode = toCode;
    }
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260


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

<<<<<<< HEAD
    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
=======
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
    }

}

package com.example.chat.entity;

import java.io.Serializable;

/**
 * (FriendRelation)实体类
 *
 * @author makejava
 * @since 2022-03-07 12:39:01
 */
public class FriendRelation implements Serializable {
    private static final long serialVersionUID = 884149504724258235L;

    private Integer id;

    private String fromcode;

    private String friendid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromcode() {
        return fromcode;
    }

    public void setFromcode(String fromcode) {
        this.fromcode = fromcode;
    }

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }

}


package com.example.chat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NettyMapper {

    int insertFriend(String fromCode,String toCode);

}

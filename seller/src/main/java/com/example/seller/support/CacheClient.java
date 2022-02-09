package com.example.seller.support;


import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CacheClient {

    private final RedisTemplate<String, Object> redisTemplate;


    public CacheClient(RedisTemplate<String, Object> redisTemplate, ApplicationContext applicationContext) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        this.redisTemplate = redisTemplate;
    }


    public Object getValue(String key) {
        if (key == null || "".equals(key)) {
            return null;
        } else {
//            System.out.println("命中cache");
//            return "success";
            return redisTemplate.opsForValue().get(key);
        }
    }

    public void putValue(String key, Object o, int expire) {
        if (!("".equals(key))) {

//            System.out.println("命中cache");
//            return "success";
            redisTemplate.opsForValue().set(key, o, expire, TimeUnit.SECONDS);
        }
    }
}

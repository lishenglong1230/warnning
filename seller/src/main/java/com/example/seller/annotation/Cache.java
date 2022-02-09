package com.example.seller.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//1、通过redis缓存，查询数据
//2、从数据库中查出的数据，写到缓存中
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Cache {
    //标识当前缓存的过期时间
    int expire() default 3600;
}

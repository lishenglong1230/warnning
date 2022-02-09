package com.example.seller.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//1、将数据库中的数据写入缓存
//2、把原有缓存数据删除
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CachePut {
    int expire() default 10;


}

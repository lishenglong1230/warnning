package com.example.assess.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*@AllArgsConstructor  : 它是lombok中的注解,作用在类上;
使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数*/
public class Person {
    @JsonIgnore
    private Integer id;
    private String name;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}

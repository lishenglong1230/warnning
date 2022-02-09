package com.example.buyers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.buyer.dao")
public class BuyerApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.example.buyers.BuyerApplication.class, args);
	}

}

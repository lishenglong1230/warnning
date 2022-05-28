package com.example.chat;


import com.example.chat.websocket.NioWebSocketHandler;
import com.example.chat.websocket.NioWebSocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.example.chat.mapper")
public class ChatApplication implements CommandLineRunner {


    @Autowired
    private NioWebSocketServer server;


    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        server.init();
    }
}

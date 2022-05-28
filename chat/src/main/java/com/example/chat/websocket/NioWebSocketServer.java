package com.example.chat.websocket;

<<<<<<< HEAD
import com.example.chat.entity.Message;
import com.example.chat.mapper.NettyMapper;
import com.example.chat.service.MessageService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.logging.Logger;

@Component
public class NioWebSocketServer {
    private final Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @Autowired
    private MessageService messageService;


    public void init() throws InterruptedException {
        logger.info("正在启动websocket服务器");
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new HttpServerCodec());
                            ch.pipeline().addLast(new ChunkedWriteHandler());
                            ch.pipeline().addLast(new HttpObjectAggregator(1024 * 62));
                            ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));
                            ch.pipeline().addLast(new NioWebSocketHandler(messageService));
                        }
                    });
            Channel channel = bootstrap.bind(8099).sync().channel();
            logger.info("webSocket服务器启动成功：" + channel);
            channel.closeFuture().sync();
        } finally {
=======
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.logging.Logger;

public class NioWebSocketServer {
    private final Logger logger= Logger.getLogger(String.valueOf(this.getClass()));
    private void init() throws InterruptedException {
        logger.info("正在启动websocket服务器");
        NioEventLoopGroup boss=new NioEventLoopGroup();
        NioEventLoopGroup work=new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new NioWebSocketChannelInitializer());
            Channel channel = bootstrap.bind(8081).sync().channel();
            logger.info("webSocket服务器启动成功："+channel);
            channel.closeFuture().sync();
        }finally {
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
            boss.shutdownGracefully();
            work.shutdownGracefully();
            logger.info("websocket服务器已关闭");
        }
    }

<<<<<<< HEAD
//    public static void main(String[] args) throws InterruptedException {
//        new NioWebSocketServer().init();
//    }
=======
    public static void main(String[] args) throws InterruptedException {
        new NioWebSocketServer().init();
    }
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
}

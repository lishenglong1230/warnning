package com.example.chat.websocket;

<<<<<<< HEAD
import com.example.chat.mapper.NettyMapper;
=======
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class NioWebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private NettyMapper nettyMapper;
=======

public class NioWebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new HttpServerCodec());
        socketChannel.pipeline().addLast(new ChunkedWriteHandler());
        socketChannel.pipeline().addLast(new HttpObjectAggregator(1024 * 62));
        socketChannel.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));
<<<<<<< HEAD
//        socketChannel.pipeline().addLast(new NioWebSocketHandler());
=======
        socketChannel.pipeline().addLast(new NioWebSocketHandler());
>>>>>>> 16760b4bca10ce995bb4f9b6b4f25fb740b75260
    }

}


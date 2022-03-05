package com.example.chat.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.chat.entity.Message;
import com.example.chat.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Netty服务器的核心处理类
 */

public class NioWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final Logger logger = Logger.getLogger(String.valueOf(NioWebSocketHandler.class));

    public static ConcurrentHashMap<String, Channel> channelMap = new ConcurrentHashMap<>();

//    private WebSocketServerHandshaker handshaker;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame webSocketFrame) throws Exception {
//        logger.info("收到消息："+msg);
//        Message message = new Gson().fromJson(webSocketFrame.text(), Message.class);
//        logger.info(ctx.channel().remoteAddress() + "---->" + message.getContent() + "----->" +message.getTimestamp());
//
//        Channel channel = channelMap.get(message.getId());
//
//        if (channel == null){
//            sendMessageByChannel(ctx.channel(),new Message(ctx.channel().id().asShortText(),"对方已下线",System.currentTimeMillis(),MessageType.CHAT_MSG.name()));
//        }else {
//            sendMessageByChannel(ctx.channel(), message);
//        }

//        if (webSocketFrame instanceof FullHttpRequest){
//            //以http请求形式接入，但是走的是websocket
//            handleHttpRequest(ctx, (FullHttpRequest) webSocketFrame);
//        }else
//       if (webSocketFrame instanceof WebSocketFrame){
            //处理websocket客户端的消息
            handlerWebSocketFrame(ctx, webSocketFrame);
//        }
    }

    private void handlerWebSocketFrame(ChannelHandlerContext ctx, TextWebSocketFrame webSocketFrame){
        Message message = new Gson().fromJson(webSocketFrame.text(), Message.class);
        //接收到前端的消息
//        String text = webSocketFrame.text();
        //转换消息格式
//        Message message = exchangeChatMessage(ctx.channel(), text);
        String toCode = message.getToCode();

        Channel channel = channelMap.get(toCode);
        if (channel == null){
            ctx.channel().writeAndFlush(new TextWebSocketFrame(new Gson().toJson(new Message("对方已下线",message.getTimestamp(),message.getFromCode(),message.getToCode()))));
        }else {
            channel.writeAndFlush(new TextWebSocketFrame(JsonUtil.getJson(message)));
        }

        logger.info(message.getContent());
    }


    //转换消息格式
//    private Message exchangeChatMessage(Channel channel, String text) {
//        JSONObject jsonObject = JSONObject.parseObject(text);
//        Message message = JSON.toJavaObject(jsonObject, Message.class);
//
//
//        return message;
//    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelMap.put(ctx.channel().id().asShortText(), ctx.channel());
        System.out.println(ctx.channel().remoteAddress() + "上线！" + "--->" + ctx.channel().id().asShortText());
    }


//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        //添加连接
//        logger.info(ctx.channel().remoteAddress() + "上线！" + "--->" + ctx.channel().id().asShortText());
//    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //断开连接
        logger.info(ctx.channel().remoteAddress() + "下线！");
    }

    private void sendMessageByChannel(Channel channel, Message message) {
        channel.writeAndFlush(new TextWebSocketFrame(new Gson().toJson(message)));
    }
}

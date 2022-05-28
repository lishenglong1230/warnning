package com.example.chat.websocket;


import com.alibaba.fastjson.JSONObject;
import com.example.chat.entity.Message;
import com.example.chat.service.MessageService;
import com.example.chat.util.JsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Netty服务器的核心处理类
 */
@Component
public class NioWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

//    public static NioWebSocketHandler nioWebSocketHandler;

    private final Logger logger = Logger.getLogger(String.valueOf(NioWebSocketHandler.class));

    public static ConcurrentHashMap<String, Channel> channelMap = new ConcurrentHashMap<>();

    private MessageService messageService;

    public NioWebSocketHandler(MessageService messageService) {

        this.messageService = messageService;
    }

//    @PostConstruct
//    public void init(){
//        nioWebSocketHandler = this;
//        nioWebSocketHandler.messageService = this.messageService;
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame webSocketFrame) throws Exception {

        handlerWebSocketFrame(ctx, webSocketFrame);

    }


    private void handlerWebSocketFrame(ChannelHandlerContext ctx, TextWebSocketFrame webSocketFrame) {

        TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame) webSocketFrame;

        ByteBuf bytebuf = textWebSocketFrame.content();

        //从content中写入缓冲区
        String content = bytebuf.toString(Charset.forName("utf-8"));

        JSONObject jsonObject = JSONObject.parseObject(content);

        //将json字符串转变为json对象
        logger.info(content);

        //从json对象中按属性取值
        Byte type = jsonObject.getByte("type");

        JSONObject parmas = jsonObject.getJSONObject("params");

        switch (type) {
            // 注册user-->channel 映射
            case 7:
                channelMap.put(parmas.getString("fromCode"), ctx.channel());
                break;
            //私聊
            case 1:
                Message message = new Message();
                message.setFromCode(parmas.getString("fromCode"));
                message.setContent(parmas.getString("content"));
                message.setToCode(parmas.getString("toCode"));
                message.setSendTime(parmas.getString("sendTime"));

                String toCode = message.getToCode();

                Channel channel = channelMap.get(toCode);
                if (channel == null) {
                    ctx.ch().writeAndFlush(new TextWebSocketFrame("对方已经下线"));
                } else {
                    channel.writeAndFlush(new TextWebSocketFrame(JsonUtil.getJson(message)));
                }
                messageService.AddMessage(message);

                logger.info(message.getContent());
                break;
        }


    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

//        channelMap.put(ctx.channel().id().asShortText(), ctx.channel());
        logger.info(ctx.channel().remoteAddress() + "上线！" + "--->" + ctx.channel().id().asShortText());
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //断开连接
        logger.info(ctx.channel().remoteAddress() + "下线！");
    }


}

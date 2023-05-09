package com.it.netty.netty_long_keep.c;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

@Slf4j
public class ClientBizHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("channelRead");
        ByteBuf req = (ByteBuf) msg;
        byte[] res = new byte[req.readableBytes()];
        req.readBytes(res);
        new Thread(() -> {
            log.info("消息: " + new String(res, StandardCharsets.UTF_8));
        }).start();
    }
}

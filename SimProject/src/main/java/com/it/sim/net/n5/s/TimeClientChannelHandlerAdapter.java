package com.it.sim.net.n5.s;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class TimeClientChannelHandlerAdapter extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("channelActive");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf req = (ByteBuf) msg;
        byte[] reqInfo = new byte[req.readableBytes()];
        req.readBytes(reqInfo);
        System.out.println(new String(reqInfo, StandardCharsets.UTF_8));
        String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String res = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
        ctx.writeAndFlush(Unpooled.copiedBuffer(res.getBytes()));
    }
}

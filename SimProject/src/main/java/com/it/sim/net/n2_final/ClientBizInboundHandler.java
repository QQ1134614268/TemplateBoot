package com.it.sim.net.n2_final;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ClientBizInboundHandler extends ChannelInboundHandlerAdapter {
    // connect 客户端执行connect连接服务端时进入
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
        log.info("connect");
        ctx.connect(remoteAddress, localAddress, promise);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("channelRead");
        ByteBuf req = (ByteBuf) msg;
        byte[] res = new byte[req.readableBytes()];
        req.readBytes(res);
        new Thread(() -> log.info("消息: " + new String(res, StandardCharsets.UTF_8))).start();
    }
}

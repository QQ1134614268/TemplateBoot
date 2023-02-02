package com.it.sim.net.n2_final;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

import java.net.SocketAddress;

@Slf4j
public class ClientBizOutboundHandler extends ChannelOutboundHandlerAdapter {
    // connect 客户端执行connect连接服务端时进入
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
        log.info("connect");
        ctx.connect(remoteAddress, localAddress, promise);
    }

    @Override
    public void read(ChannelHandlerContext ctx) {
        log.info("read");
        ctx.read();
    }


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
        log.info("write");
        ctx.write(msg, promise);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) {
        log.info("flush");
        ctx.flush();
    }
}

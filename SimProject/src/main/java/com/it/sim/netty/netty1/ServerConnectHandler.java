package com.it.sim.netty.netty1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

import java.net.SocketAddress;

@Slf4j
public class ServerConnectHandler extends ChannelInboundHandlerAdapter {

    // bind 服务端执行bind时，会进入到这里，我们可以在bind前及bind后做一些操作
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) {
        log.info("bind");
        ctx.bind(localAddress, promise);
    }

    // connect 客户端执行connect连接服务端时进入
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
        log.info("connect");
        ctx.connect(remoteAddress, localAddress, promise);
    }

    // 通道激活时触发，当客户端connect成功后，服务端就会接收到这个事件，从而可以把客户端的Channel记录下来，供后面复用
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("channelActive");
        // ctx.fireChannelActive();
    }

}

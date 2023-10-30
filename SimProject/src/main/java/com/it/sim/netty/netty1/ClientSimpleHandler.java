package com.it.sim.netty.netty1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientSimpleHandler<T> extends SimpleChannelInboundHandler<T> {

    /**
     * messageReceived 被
     * 接收发送的消息 channel 通道 Read 读 简而言之就是从通道中读取数据，也就是服务端接收客户端发来的数据。
     * 但是这个数据在不进行解码时它是ByteBuf类型的
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, T obj) {
        log.info("messageReceived");
    }
}

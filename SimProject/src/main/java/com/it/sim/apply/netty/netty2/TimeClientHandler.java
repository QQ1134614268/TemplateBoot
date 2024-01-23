package com.it.sim.apply.netty.netty2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class TimeClientHandler extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(new TimeClientChannelHandlerAdapter());
    }
}

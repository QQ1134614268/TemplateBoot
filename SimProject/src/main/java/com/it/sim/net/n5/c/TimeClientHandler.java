package com.it.sim.net.n5.c;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class TimeClientHandler extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(new TimeClientChannelHandlerAdapter());
    }
}

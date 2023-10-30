package com.it.sim.netty.netty2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {
    public static void main(String[] args) {
        //启动服务类
        startServer();
    }

    private static void startServer() {
        //用于处理accept事件
        EventLoopGroup boss = new NioEventLoopGroup();
        //用于处理通道的读写事件
        EventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap sb = new ServerBootstrap();
        //主线程其实就是serverSocket，这里使用的是Nio，所以需要指定类型为NioServerSocketChannel
        //childHandler，其实自己定义如何处理，服务端这边的通道
        sb.group(boss, work).option(ChannelOption.SO_BACKLOG, ConnectConfig.getSoBacklog())
                .channel(NioServerSocketChannel.class)
                .childHandler(new TimeServerChannelHandler());

        ChannelFuture cf;
        try {
            //服务端绑定端口，直到绑定成功，会一直阻塞
            cf = sb.bind(ConnectConfig.getPort()).sync();
            //服务端的主通道，直到等到关闭，会一直阻塞
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //将对应的监听线程关闭，避免线程没有杀死
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}

package com.it.sim.net.n5.c;

import com.it.sim.net.n5.ConnectConfig;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

@SuppressWarnings("SpellCheckingInspection")
public class TimeClient {
    public static void main(String[] args) {
        connect();
    }
    
    private static void connect() {
        //用于客户端处通道的读写
        EventLoopGroup work = new NioEventLoopGroup();
        
        Bootstrap b = new Bootstrap();
        // b.group(work).option(ChannelOption.TCP_NODELAY, true).channel(NioSocketChannel.class)
        //         .handler(new StringEncoder())
        //         .handler(new TimeClientHandler());
        b.group(work).option(ChannelOption.TCP_NODELAY, true)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
         @Override
         protected void initChannel(Channel channel) {
             channel.pipeline().addLast(new StringEncoder());
             channel.pipeline().addLast(new StringDecoder());
             channel.pipeline().addLast(new TimeClientHandler());
         }
     });
        ChannelFuture cf;
        try {
            //一直阻塞，直到连接上服务端
            cf = b.connect(ConnectConfig.getHost(), ConnectConfig.getPort()).sync();
            //一直阻塞，直到该通道关闭
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //避免线程没有杀死
            work.shutdownGracefully();
        }
    }
}
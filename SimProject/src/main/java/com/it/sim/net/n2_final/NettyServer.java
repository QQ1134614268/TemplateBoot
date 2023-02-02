package com.it.sim.net.n2_final;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServer {
    public static void main(String[] args) {
        new NettyServer().asyncRun();
    }

    public void asyncRun() {
        new Thread(() -> new NettyServer().run()).start();
    }

    public void run() {
        // Boss线程：由这个线程池提供的线程是boss种类的，用于创建、连接、绑定socket， （有点像门卫）然后把这些socket传给worker线程池。
        // 在服务器端每个监听的socket都有一个boss线程来处理。在客户端，只有一个boss线程来处理所有的socket。
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // Worker线程：Worker线程执行所有的异步I/O，即处理操作
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        // 初始化channel时，添加处理器
                        ch.pipeline().addLast(new ServerConnectHandler());
                        ch.pipeline().addLast(new ServerBizInboundHandler());
                        ch.pipeline().addLast(new ServerBizOutboundHandler());
                    }
                });
        try {
            // 获取Channel的CloseFuture，并阻塞知道它完成
            ChannelFuture cf = serverBootstrap.bind(Conf.port).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("异常", e);
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
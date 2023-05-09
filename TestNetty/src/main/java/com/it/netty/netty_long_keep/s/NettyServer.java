package com.it.netty.netty_long_keep.s;

import com.it.netty.Conf;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Slf4j
@Component
public class NettyServer {


    public static ServerSocketChannel serverSocketChannel;

    @PostConstruct
    public void asyncStart() {
       new Thread(()-> new NettyServer().start()).start();
    }

    public static void main(String[] args) {
        new NettyServer().start();
    }
    public void start() {
        // 连接处理group
        EventLoopGroup boss = new NioEventLoopGroup();
        // 事件处理group
        EventLoopGroup worker = new NioEventLoopGroup();
        //1.创建ServerBootStrap实例
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 绑定处理group
        //2.设置并绑定Reactor线程池：EventLoopGroup，EventLoop就是处理所有注册到本线程的Selector上面的Channel
        bootstrap.group(boss, worker)
                //3.设置并绑定服务端的channel
                .channel(NioServerSocketChannel.class)
                // 保持连接数
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 有数据立即发送
                .option(ChannelOption.TCP_NODELAY, true)
                // 保持连接
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 处理新连接
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        sc.pipeline().addLast(new StringEncoder());
                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast(new ByteArrayEncoder());
                        sc.pipeline().addLast(new ByteArrayDecoder());
                        // // 增加任务处理
                        // ChannelPipeline pipeline = sc.pipeline();
                        // pipeline.addLast(new HttpServerCodec());
                        // //支持写大数据流
                        // pipeline.addLast(new ChunkedWriteHandler());
                        // //http聚合器
                        // pipeline.addLast(new HttpObjectAggregator(1024 * 62));
                        // //websocket支持,设置路由
                        // pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                        sc.pipeline().addLast(new NettyServerBizHandler());     // 自定义的处理器
                    }
                });

        // 绑定端口，同步等待成功
        ChannelFuture future;
        try {
            log.info("netty服务器在[{}]端口启动监听", Conf.port_long_30002);
            //真正让netty跑起来的重点
            future = bootstrap.bind(Conf.port_long_30002).sync();
            if (future.isSuccess()) {
                serverSocketChannel = (ServerSocketChannel) future.channel();
                log.info("netty服务开启成功: " + Conf.port_long_30002);
            } else {
                log.info("netty服务开启失败: " + Conf.port_long_30002);
            }
            // // 等待服务监听端口关闭,就是由于这里会将线程阻塞，导致无法发送信息，所以我这里开了线程
            future.channel().closeFuture().sync();
            log.error("服务关闭了: " + Conf.port_long_30002);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 优雅地退出，释放线程池资源
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}

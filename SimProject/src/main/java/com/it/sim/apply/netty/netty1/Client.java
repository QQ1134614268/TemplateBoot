package com.it.sim.apply.netty.netty1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
// netty 解码器
//         一次解码器:ByteToMessageDecoder
//         io.netty.buffer.ByteBuf (原始数据流)-> io.netty.buffer.ByteBuf (用户数据)

//         内置解码器
//         LineBasedFrameDecoder: 是一个特殊的分隔符解码器，该解码器使用的分隔符为：windows的r\n和类linux的\n。
//         DelimiterBasedFrameDecoder: 是更通用的分隔符解码器，可支持多个分隔符，每个分隔符可为一个或多个字符。
//         FixedLengthFrameDecoder: 按照固定长度frameLength解码出消息帧
//         LengthFieldBasedFrameDecoder: 基于长度字段的消息帧解码器，该解码器可根据数据包中的长度字段动态的解码出消息帧。
//
//         二次解码器:MessageToMessageDecoder
//         io.netty.buffer.ByteBuf (用户数据)-> Java Object : 常用的二次解码器，json、Protobuf、xml等
//
//         编解码字符串的StringEncoder和StringDecoder
//
//         编解码对象的ObjectEncoder和ObjectDecoder
//
//         编解码字节码的ByteArrayEncoder和ByteArrayDecoder
//
//         编解码Protobuf的ProtobufEncoder和ProtobufDecoder
@Slf4j
public class Client {
    // NioEventLoopGroup workGroup = new NioEventLoopGroup();
    private final int delaySeconds = 5;

    public static void main(String[] args) {
        new Client().asyncStart();
    }

    public void asyncStart() {
        new Thread(() -> new Client().start()).start();
    }

    public void start() {
        log.info("开始连接");
        // workGroup: 方法里还是全局的??
        // 全局静态变量: 也可以执行workGroup.shutdownGracefully(),申请的线程没有注销?;
        // 项目启动申请,停止时注销, 直至进程终结
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) {
                            channel.pipeline().addLast(new ClientConnectHandler());
                            channel.pipeline().addLast(new ClientBizInboundHandler());
                            channel.pipeline().addLast(new ClientBizOutboundHandler());
                            // channel.pipeline().addLast(new ClientSimpleHandler<String>());
                        }
                    });
            ChannelFuture future = bootstrap.connect(Conf.host, Conf.port); //.sync()会抛出异常,跳过监听设置.重启失败. 捕捉异常
            // Thread.sleep(5000); // 如果睡眠, 结果已经返回,监听不到消息, 重启失败??
            // 监听重新连接
            future.addListener((ChannelFuture cf) -> {
                if (!cf.isSuccess()) {
                    log.error("连接失败,进行断线重连");
                    // new NettyClient().asyncStart();
                    cf.channel().eventLoop().schedule(this::start, delaySeconds, TimeUnit.SECONDS);
                    // Thread.sleep(delayMillis);
                }
                // log.info("连接成功");
            });
            // 关闭通道连接监听
            future.channel().closeFuture();
        } catch (Exception e) {
            log.error("异常", e);
            // throw new RuntimeException(e); // 抛出异常会被 exceptionCaught捕捉
        } finally {
            /*优雅退出，释放NIO线程组*/
            try {
                Thread.sleep(delaySeconds * 1000);
            } catch (InterruptedException e) {
                log.error("异常", e);
            }
            workGroup.shutdownGracefully();
            // 参考: https://blog.csdn.net/m0_45406092/article/details/104634198
        }
    }

}

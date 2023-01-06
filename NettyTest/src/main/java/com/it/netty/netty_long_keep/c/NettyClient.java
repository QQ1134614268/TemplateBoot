package com.it.netty.netty_long_keep.c;

import com.it.netty.Conf;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class NettyClient {
    // NioEventLoopGroup workGroup = new NioEventLoopGroup();
    private final int delaySeconds = 5;
    private final int delayMillis = delaySeconds * 1000;

    public static void main(String[] args) {
        new NettyClient().start();
    }

    @PostConstruct
    public void asyncStart() {

        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new NettyClient().start();
        }).start();
    }

    public void start() {
        log.info("开始连接");
        // workGroup: 方法里还是全局的??全局静态变量: 也可以执行workGroup.shutdownGracefully(),申请的线程没有注销?;
        // 项目启动申请,停止时注销, 直至进程终结
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new IdleStateHandler(4, 8, 12));
                            channel.pipeline().addLast(new StringDecoder());
                            channel.pipeline().addLast(new StringEncoder());
                            channel.pipeline().addLast(new ClientConnectHandler());
                            // channel.pipeline().addLast(new ClientBizHandler());
                            // channel.pipeline().addLast(new ClientSimpleHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(Conf.host, Conf.port_long_30002); //.sync()会抛出异常,跳过监听设置.重启失败. 捕捉异常
            // Thread.sleep(5000); // 如果睡眠, 结果已经返回,监听不到消息, 重启失败??
            // 监听重新连接
            future.addListener((ChannelFuture cf) -> {
                if (!cf.isSuccess()) {
                    log.error("连接失败,进行断线重连");
                    // Thread.sleep(delayMillis);
                    // new NettyClient().asyncStart();
                    cf.channel().eventLoop().schedule(() -> start(), delaySeconds, TimeUnit.SECONDS);
                } else {
                    log.info("连接成功");
                }
                // return;
            });
            // 关闭通道连接监听
            future.channel().closeFuture().sync();
            log.error("长连接异常关闭: " + Conf.port_long_30002);
        } catch (Exception e) {
            log.error("异常", e);
            // throw new RuntimeException(e); // 抛出异常会被 exceptionCaught捕捉
        } finally {
            /**优雅退出，释放NIO线程组*/
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // todo 退出前, 还没有到时间的定时任务,会取消执行,导致重启失败 ?
            //  所以需要延迟关闭, 或者不关闭,直至进程终结
            workGroup.shutdownGracefully();
            // 参考: https://blog.csdn.net/m0_45406092/article/details/104634198
        }
    }

}

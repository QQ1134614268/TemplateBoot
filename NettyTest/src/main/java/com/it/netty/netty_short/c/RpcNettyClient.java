package com.it.netty.netty_short.c;

import com.it.netty.Conf;
import com.it.netty.netty_short.JsonDecoder;
import com.it.netty.netty_short.JsonEncoder;
import com.it.netty.netty_short.RpcRequest;
import com.it.netty.netty_short.RpcResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;

/**
 * RPC远程调用的客户端
 */
@Slf4j
@Component
public class RpcNettyClient {
    @Value("${rpc.server.ip}")
    private String remoteIp;

    @Value("${rpc.server.port}")
    private int port;

    private Bootstrap bootstrap;

    // 储存调用结果
    private final Map<String, SynchronousQueue<RpcResponse>> results = new ConcurrentHashMap<>();

    public RpcNettyClient() {
    }

    @PostConstruct
    public void asyncInit() {
        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new RpcNettyClient().init();
        }).start();
    }

    public void init() {
        bootstrap = new Bootstrap().remoteAddress(Conf.host, Conf.port_short);
        NioEventLoopGroup worker = new NioEventLoopGroup(1);
        bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new IdleStateHandler(0, 0, 10));
                        pipeline.addLast(new JsonEncoder());
                        pipeline.addLast(new JsonDecoder());
                        pipeline.addLast(new RpcClientInboundHandler(results));
                    }
                });
    }

    public RpcResponse send(RpcRequest rpcRequest) {
        RpcResponse rpcResponse = null;
        rpcRequest.setRequestId(UUID.randomUUID().toString());
        Channel channel = null;
        try {
            channel = bootstrap.connect().sync().channel();
            log.info("连接建立, 发送请求:{}", rpcRequest);
            channel.writeAndFlush(rpcRequest);
            SynchronousQueue<RpcResponse> queue = new SynchronousQueue<>();
            results.put(rpcRequest.getRequestId(), queue);
            // 阻塞等待获取响应
            rpcResponse = queue.take();
            results.remove(rpcRequest.getRequestId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (channel != null && channel.isActive()) {
                channel.close();
            }
        }
        return rpcResponse;
    }
}
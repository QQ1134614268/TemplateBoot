package com.it.sim.netty.netty1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

@Slf4j
public class ServerBizInboundHandler extends ChannelInboundHandlerAdapter {

    // 对于每个传入的消息都要调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("channelRead");
        // 记录已接收的消息
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("channelRead " + byteBuf.toString(StandardCharsets.UTF_8));
    }

    // 通知 ChannelInboundHandlerAdapter 最后一次 channelRead()的调用
    // 是当前批量读取中的最后一条消息
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        log.info("channelReadComplete");
        // ctx.fireChannelReadComplete();
    }

    // 在读取操作期间，有异常抛出时调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("exceptionCaught", cause);
        // 关闭Channel
        ctx.channel();
        // 打印异常
        // throw new RuntimeException(cause);
        // cause.printStackTrace();
    }
}

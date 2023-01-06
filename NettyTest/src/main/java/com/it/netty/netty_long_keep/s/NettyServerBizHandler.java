package com.it.netty.netty_long_keep.s;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Slf4j
@Component
public class NettyServerBizHandler extends ChannelHandlerAdapter {

    /**
     * 在与客户端的连接已经建立之后将被调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("netty客户端与服务端连接开始...");
        //获取每个用户端连接的ip
        InetSocketAddress ipSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = ipSocket.getAddress().getHostAddress();
        NettyPushUtil.addChannel(clientIp, ctx.channel());
        ctx.writeAndFlush("连接成功");
    }


    /**
     * 客户端与服务端断开连接时调用
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.error("channelInactive...");
        InetSocketAddress ipSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = ipSocket.getAddress().getHostAddress();
        NettyPushUtil.removeChannelByName(clientIp);
    }


    /**
     * 在处理过程中引发异常时被调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("异常", cause);
        ctx.close();
    }
}

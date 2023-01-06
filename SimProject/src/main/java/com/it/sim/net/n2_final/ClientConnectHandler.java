package com.it.sim.net.n2_final;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

import java.net.SocketAddress;
import java.time.LocalDateTime;

@Slf4j
public class ClientConnectHandler extends ChannelInboundHandlerAdapter {
    // connect 客户端执行connect连接服务端时进入
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
        log.info("connect");
        ctx.connect(remoteAddress, localAddress, promise);
    }

    // 通道激活时触发，当客户端connect成功后，服务端就会接收到这个事件，从而可以把客户端的Channel记录下来，供后面复用
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("channelActive");
        ctx.fireChannelActive();
    }

    /**
     * channel 通道 Inactive 不活跃的 当客户端主动断开服务端的链接后，
     * 这个通道就是不活跃的。也就是说客户端与服务端关闭了通信通道并且不可以传输数据
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.error("channelInactive -- 断线重连");
        ctx.fireChannelInactive();
    }


    //当收到对方发来的数据后，就会触发，参数msg就是发来的信息，可以是基础类型，也可以是序列化的复杂对象
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("channelRead");
        ctx.fireChannelRead(msg);
    }

    public void channelReadComplete(ChannelHandlerContext ctx) {
        log.info("channelReadComplete");
        ctx.fireChannelReadComplete();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("exceptionCaught");
        super.exceptionCaught(ctx, cause);
    }

    //对Netty心跳检测事件进行处理，几秒没有写操作的话，发送一个心跳信息过去，以防止服务端关闭ctx
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info("userEventTriggered 已经断开了连接，准备发送心跳检查 ：" + LocalDateTime.now());
        // 关闭通道会重新调用重新连接
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                log.info("已经长时间没有接收到服务器的消息，重新连接！");
                // 关闭通道会直接调用重新连接
                ctx.close();
            } else if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
                log.info("已经长时间没有发送消息给服务器,发送心跳，重新连接！");
                // 关闭通道会直接调用重新连接
                ctx.close();
            } else if (idleStateEvent.state() == IdleState.ALL_IDLE) {
                log.info("已经长时间没有发送消息给服务器,重新连接！");
                // 关闭通道会直接调用重新连接
                ctx.close();
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}

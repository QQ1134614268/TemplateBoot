package com.it.netty.netty_long_keep.c;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

import java.net.SocketAddress;

@Slf4j
public class ClientConnectHandler extends ChannelHandlerAdapter {
    // connect 客户端执行connect连接服务端时进入
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        log.info("connect");
        ctx.connect(remoteAddress, localAddress, promise);
    }

    // 通道激活时触发，可以把客户端的Channel记录下来，供后面复用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("channelActive");
        // ctx.fireChannelActive();
    }


    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        log.info("read");
        ctx.read();
    }

    //当收到对方发来的数据后，就会触发，参数msg就是发来的信息，可以是基础类型，也可以是序列化的复杂对象
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("channelRead: "+ msg);
        // ctx.fireChannelRead(msg);
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("channelReadComplete");
        // ctx.fireChannelReadComplete();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("exceptionCaught");
        // super.exceptionCaught(ctx, cause);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        log.info("write");
        ctx.write(msg, promise);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        log.info("flush");
        ctx.flush();
    }

    // //对Netty心跳检测事件进行处理，几秒没有写操作的话，发送一个心跳信息过去，以防止服务端关闭ctx
    // @Override
    // public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    //     log.info("userEventTriggered 已经断开了连接，准备发送心跳检查 ：" + LocalDateTime.now());
    //     // 关闭通道会重新调用重新连接
    //     if (evt instanceof IdleStateEvent) {
    //         IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
    //         if (idleStateEvent.state() == IdleState.READER_IDLE) {
    //             log.info("已经长时间没有接收到服务器的消息，重新连接！");
    //             // 关闭通道会直接调用重新连接
    //             ctx.close();
    //         } else if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
    //             log.info("已经长时间没有发送消息给服务器,发送心跳，重新连接！");
    //             // 关闭通道会直接调用重新连接
    //             ctx.close();
    //         } else if (idleStateEvent.state() == IdleState.ALL_IDLE) {
    //             log.info("已经长时间没有发送消息给服务器,重新连接！");
    //             // 关闭通道会直接调用重新连接
    //             ctx.close();
    //         }
    //     } else {
    //         super.userEventTriggered(ctx, evt);
    //     }
    // }
}

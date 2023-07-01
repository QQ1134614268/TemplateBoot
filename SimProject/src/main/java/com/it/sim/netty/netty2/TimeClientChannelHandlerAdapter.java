package com.it.sim.netty.netty2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientChannelHandlerAdapter extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String req = "what time it is";
        ctx.writeAndFlush(req);
        // netty writeAndFlush不起作用: 相应的类型就可以编码传输了.

        // 没有string转码器,只能写入 writeAndFlush ByteBuf类型数据
        // ByteBuf f = Unpooled.copiedBuffer("req".getBytes());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // ByteBuf req = (ByteBuf) msg;
        // byte[] reqInfo = new byte[req.readableBytes()];
        // req.readBytes(reqInfo);
        // System.out.println("now is " + new String(reqInfo, "UTF-8"));

        String req = (String) msg;
        System.out.println("now is " + req);
    }
}
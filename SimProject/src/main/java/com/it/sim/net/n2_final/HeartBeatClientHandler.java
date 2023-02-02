package com.it.sim.net.n2_final;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        // if (evt instanceof IdleStateEvent){
        //     IdleStateEvent event = (IdleStateEvent)evt;
        //     switch (event.state()) {
        //         case WRITER_IDLE:
        //             if (curTime<beatTime){
        //                 curTime++;
        //                 ctx.writeAndFlush("biu");
        //             }
        //         default:
        //             break;
        //     }
    }
}

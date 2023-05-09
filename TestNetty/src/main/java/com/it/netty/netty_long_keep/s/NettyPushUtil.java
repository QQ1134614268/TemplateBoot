package com.it.netty.netty_long_keep.s;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class NettyPushUtil {

    public static ConcurrentHashMap<String, Channel> channelHashMap = new ConcurrentHashMap<>();


    /**
     * 获取指定name的channel
     */
    public static Channel getChannelByName(String name) {
        return channelHashMap.get(name);
    }

    /**
     * 将通道中的消息推送到每一个客户端
     */
    public static boolean pushNewsToAllClient(String obj) {
        log.info("当前长连接个数" + channelHashMap.size());
        for (String name : channelHashMap.keySet()) {
            Channel channel = channelHashMap.get(name);
            channel.writeAndFlush(obj);
        }
        return true;
    }

    /**
     * 将channel和对应的name添加到ConcurrentHashMap
     */
    public static void addChannel(String name, Channel channel) {
        log.info("增加连接" + name);
        channelHashMap.put(name, channel);
    }

    /**
     * 移除掉name对应的channel
     */
    public static void removeChannelByName(String name) {
        log.info("移除连接" + name);
        channelHashMap.remove(name);
    }
}

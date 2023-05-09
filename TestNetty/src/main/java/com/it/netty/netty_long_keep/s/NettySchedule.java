package com.it.netty.netty_long_keep.s;


import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class NettySchedule {
    Gson gson = new Gson();

    // @Scheduled(cron = "0/5 * * * * ?")
    @Scheduled(fixedRate = 5000)
    public void pushRadarData() {
        log.info("pushRadarData");
        RadarInfo info = RadarInfo.mockRadarInfo();
        NettyPushUtil.pushNewsToAllClient(gson.toJson(info));
    }
}

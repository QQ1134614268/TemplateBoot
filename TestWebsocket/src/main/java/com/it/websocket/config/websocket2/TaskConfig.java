package com.it.websocket.config.websocket2;

import com.it.websocket.config.WsCommand;
import com.it.websocket.config.WsTopic;
import com.it.websocket.dto.News;
import com.it.websocket.dto.SysAnno;
import com.it.websocket.dto.WsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TaskConfig {

    @Resource
    WsSessionManager wsSessionManager;

    AtomicInteger atomicInteger = new AtomicInteger(1);

    @Scheduled(fixedDelay = 30000)
    public void pushSysAnno() {
        log.info("pushSysAnno");
        SysAnno sysAnno = new SysAnno();
        int andIncrement = atomicInteger.getAndIncrement();
        sysAnno.setTitle(String.valueOf(andIncrement));
        sysAnno.setContent(String.valueOf(andIncrement));
        sysAnno.setAuth("wu");
        wsSessionManager.sendAll(new WsDto("", WsCommand.getSysAnno, "1", sysAnno));
    }

    AtomicInteger atomicInteger2 = new AtomicInteger(1);

    @Scheduled(fixedDelay = 60000)
    public void pushNewsTopic() {
        log.info("pushNewsTopic");
        List<String> sessionIds = WsSessionManager.getSessionPool()
                .values()
                .stream()
                .filter(v -> v.getTopic().contains(WsTopic.TOPIC_NEWS))
                .map(v -> v.getSession().getId())
                .collect(Collectors.toList());
        if (sessionIds.isEmpty()) {
            return;
        }
        News news = new News();
        int i = atomicInteger2.getAndIncrement();
        news.setTitle(String.valueOf(i));
        news.setContent(String.valueOf(i));
        news.setAuth("wu");
        wsSessionManager.sendBatch(new ArrayList<>(sessionIds), new WsDto("", WsCommand.getNews, "1", news));
    }
}

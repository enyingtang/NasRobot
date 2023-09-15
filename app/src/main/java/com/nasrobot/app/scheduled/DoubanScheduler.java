package com.nasrobot.app.scheduled;

import com.nasrobot.app.services.douban.DoubanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DoubanScheduler {
    private final DoubanService doubanService;

    public DoubanScheduler(DoubanService doubanTopService) {
        this.doubanService = doubanTopService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void refreshDoubanTop() {
        log.info("[System] 刷新豆瓣排行榜数据开始");
        doubanService.refreshDoubanTop();
        log.info("[System] 刷新豆瓣排行榜数据完成");
    }

    @Scheduled(cron = "0 0/3 * * * ?")
    public void refreshDoubanWantWatch() {
        doubanService.refreshMineWantWatchList();
    }
}

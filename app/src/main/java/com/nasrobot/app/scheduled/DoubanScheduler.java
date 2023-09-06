package com.nasrobot.app.scheduled;

import com.nasrobot.app.services.douban.DoubanService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DoubanScheduler {
    private final DoubanService doubanService;

    public DoubanScheduler(DoubanService doubanTopService) {
        this.doubanService = doubanTopService;
    }

    /**
     * 0 0/1 * * * ?
     */
//    @Scheduled(cron = "0 0/1 * * * ?")
    @Scheduled(fixedRate = 5000)
    public void dailyTask() {
        doubanService.getDoubanTop();
    }
}

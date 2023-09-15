package com.nasrobot.app.services.douban;

import com.nasrobot.app.caches.InitConfigCache;
import com.nasrobot.app.config.system.SystemConfig;
import com.nasrobot.app.parser.DoubanTopParser;
import com.nasrobot.app.parser.DoubanWantWatchParser;
import com.nasrobot.commons.utils.CookieUtils;
import com.nasrobot.repository.entity.douban.DoubanTop;
import com.nasrobot.repository.entity.douban.DoubanWantWatch;
import com.nasrobot.repository.repository.douban.DoubanTopRepository;
import com.nasrobot.repository.repository.douban.DoubanWantWatchRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class DoubanService {

    private final DoubanTopParser doubanTopParser;
    private final DoubanWantWatchParser doubanWantWatchParser;
    private final DoubanTopRepository doubanTopRepository;
    private final SystemConfig systemConfig;
    private final InitConfigCache initConfigCache;
    private final DoubanWantWatchRepository doubanWantWatchRepository;

    public DoubanService(DoubanTopParser doubanTopParser, DoubanWantWatchParser doubanWantWatchParser, DoubanTopRepository doubanTopRepository, SystemConfig systemConfig, InitConfigCache initConfigCache, DoubanWantWatchRepository doubanWantWatchRepository) {
        this.doubanTopParser = doubanTopParser;
        this.doubanWantWatchParser = doubanWantWatchParser;
        this.doubanTopRepository = doubanTopRepository;
        this.systemConfig = systemConfig;
        this.initConfigCache = initConfigCache;
        this.doubanWantWatchRepository = doubanWantWatchRepository;
    }

    /**
     * 获取豆瓣排行榜
     */
    @Transactional
    public void refreshDoubanTop() {
        log.info("[System] 刷新豆瓣排行榜数据开始。。。");

        try {
            Connection connection = Jsoup.connect(systemConfig.getDoubanTopUrl())
                    .userAgent(systemConfig.getUserAgent())
                    .timeout(5000);
            List<DoubanTop> doubanTops = doubanTopParser.parse(connection);
            doubanTopRepository.deleteAll();
            doubanTopRepository.saveAll(doubanTops);
            log.info("[System] 刷新豆瓣排行榜数据完成。。。");
        } catch (IOException e) {
            log.error("[System] 刷新豆瓣排行榜数据异常", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 刷新我的想看列表
     */
    public void refreshMineWantWatchList() {
        try {
            log.info("[System] 开始刷新豆瓣我的想看列表");
            Connection connection = Jsoup.connect(systemConfig.getDoubanMineUrl())
                    .userAgent(systemConfig.getUserAgent())
                    .cookies(CookieUtils.cookieStringToMap(initConfigCache.get().getDoubanCookie()))
                    .timeout(5000);

            List<DoubanWantWatch> doubanWantWatches = doubanWantWatchParser.parse(connection);
            doubanWantWatchRepository.deleteAll();
            doubanWantWatchRepository.saveAll(doubanWantWatches);
            log.info("[System] 刷新豆瓣我的想看列表完成, 获取到[{}]部想看电影", doubanWantWatches.size());
        } catch (IOException e) {
            log.info("[System] 刷新豆瓣我的想看列表异常");
            throw new RuntimeException(e);
        }


    }


}

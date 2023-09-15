package com.nasrobot.app.services.init;

import com.nasrobot.app.caches.InitConfigCache;
import com.nasrobot.app.services.douban.DoubanService;
import com.nasrobot.repository.entity.system.InitConfig;
import com.nasrobot.repository.repository.system.InitConfigRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * NasRobot初始化
 */
@Service
@Slf4j
public class NasRobotInitService {

    private final InitConfigRepository initConfigRepository;
    private final DoubanService doubanService;
    private final InitConfigCache initConfigCache;

    public NasRobotInitService(InitConfigRepository initConfigRepository, DoubanService doubanService, InitConfigCache initConfigCache) {
        this.initConfigRepository = initConfigRepository;
        this.doubanService = doubanService;
        this.initConfigCache = initConfigCache;
    }

    public boolean isInited() {
        return initConfigRepository.count() > 1;
    }

    /**
     * 初始化
     */
    @Transactional
    public void init(InitConfig initConfig) {
        initConfigRepository.deleteAll();
        initConfigRepository.save(initConfig);
        // 刷新初始化配置信息缓存
        initConfigCache.refersInitConfig();
        //刷新豆瓣排行榜
        doubanService.refreshDoubanTop();
        doubanService.refreshMineWantWatchList();
        log.info("[系统] 初始化成功");
    }

}

package com.nasrobot.app.services.init;

import com.nasrobot.repository.entity.system.InitConfig;
import com.nasrobot.repository.repository.system.InitConfigRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * NasRobot初始化
 */
@Service
@Slf4j
public class NasRobotInitService {

    @Autowired
    private InitConfigRepository initConfigRepository;

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
        log.info("[系统] 初始化成功");
    }

}

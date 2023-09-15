package com.nasrobot.app.caches;

import com.nasrobot.repository.entity.system.InitConfig;
import com.nasrobot.repository.repository.system.InitConfigRepository;
import org.springframework.stereotype.Component;

@Component
public class InitConfigCache {

    private InitConfig initConfig;

    private final InitConfigRepository initConfigRepository;

    public InitConfigCache(InitConfigRepository initConfigRepository) {
        this.initConfigRepository = initConfigRepository;
    }


    public InitConfig get() {
        if (initConfig == null) {
            initConfig = initConfigRepository.findAll().iterator().next();
        }
        return initConfig;
    }

    public void refersInitConfig() {
        initConfig = initConfigRepository.findAll().iterator().next();
    }

}

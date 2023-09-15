package com.nasrobot.app.config.system;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class SystemConfig {
    /**
     * 全局默认的UA
     */
    @Value("${nosRebot.default.user-agent}")
    private String userAgent;
    /**
     * 豆瓣排行榜Url
     */
    @Value("${nosRebot.douban.top}")
    private String doubanTopUrl;
    /**
     * 豆瓣排行榜Url
     */
    @Value("${nosRebot.douban.want-watch}")
    private String doubanMineUrl;
}

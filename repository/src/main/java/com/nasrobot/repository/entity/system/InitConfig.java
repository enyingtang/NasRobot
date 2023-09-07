package com.nasrobot.repository.entity.system;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_init_config")
public class InitConfig {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 豆瓣cookie
     */
    private String doubanCookie;
    /**
     * plex地址
     */
    private String plexServerUrl;
    /**
     * plex cookie
     */
    private String plexCookie;
    /**
     * 媒体目录
     */
    private String mediaPath;
    /**
     * 下载目录
     */
    private String downloadPath;
    /**
     * PT站养护刷流地址
     */
    private String maintenancePath;
}

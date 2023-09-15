package com.nasrobot.repository.entity.system;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_init_config")
@Data
public class InitConfig {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 豆瓣URL
     */
    private String doubanUrl;
    /**
     * 豆瓣cookie
     */
    @Column(length = 2048)
    private String doubanCookie;
    /**
     * plex地址
     */
    private String plexServerUrl;
    /**
     * plex cookie
     */
    @Column(length = 2048)
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

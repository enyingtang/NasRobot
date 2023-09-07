package com.nasrobot.app.vo.request;

import lombok.Data;

@Data
public class InitConfigRequest {
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

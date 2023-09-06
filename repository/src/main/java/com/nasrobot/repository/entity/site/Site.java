package com.nasrobot.repository.entity.site;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_site")
@Data
public class Site {
    @Id
    @GeneratedValue
    private String id;
    /**
     * 站点名
     */
    private String name;
    /**
     * 域名Key
     */
    private String domain;
    /**
     * 站点地址
     */
    private String url;
    /**
     * 站点优先级
     */
    private String seq;
    /**
     * rss 订阅地址
     */
    private String rssUrlPath;
    private String cookie;
    /**
     * User- Agent
     */
    private String ua;
    /**
     * 是否启用代理
     */
    private String proxy;
    /**
     * 索引器
     */
    private String indexer;
    /**
     * 流控单位周期
     */
    private int limitInterval;
    /**
     * 流控次数
     */
    private int limitCount;
    /**
     * 流控时间间隔
     */
    private Long limitSeconds;
    /**
     * 是否启用
     */
    private boolean isActive;
    /**
     * 创建时间
     */
    private String tmCreate;
}

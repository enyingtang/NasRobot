package com.nasrobot.repository.entity.douban;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_douban_top")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoubanTop {

    @Id
    @GeneratedValue
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 副标题
     */
    private String subtitle;
    /**
     * 缩略图Url
     */
    private String thumbnailImgUrl;
    /**
     * 描述
     */
    @Column(name = "`desc`", length = 2048)
    private String desc;
    /**
     * 评分
     */
    private String rating;
    /**
     * 评价人数
     */
    private String numberOfReviews;
    /**
     * 排序
     */
    @Column(name = "`order`")
    private int order;

}

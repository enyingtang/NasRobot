package com.nasrobot.repository.entity.douban;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_douban_top")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoubanTop {

    @Id
    @GeneratedValue
    private Long id;
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
    private int order;

}

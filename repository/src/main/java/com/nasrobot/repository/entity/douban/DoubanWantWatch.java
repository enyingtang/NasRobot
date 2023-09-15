package com.nasrobot.repository.entity.douban;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_douban_want_watch")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoubanWantWatch {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 子标题
     */
    private String subTitle;
    /**
     * 缩略图
     */
    private String thumbnailImgUrl;
    /**
     * 描述
     */
    @Column(name = "`desc`", length = 2048)
    private String desc;
    /**
     * 添加想看日期
     */
    private String wantWatchDate;
    /**
     * 想看标签
     */
    private String wantWatchTags;


}

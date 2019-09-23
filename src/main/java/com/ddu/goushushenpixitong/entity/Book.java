package com.ddu.goushushenpixitong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 图书
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    /**
     * 图书编号
     */
    @Id
    private String id;

    /**
     * 图书名字
     */
    @NotNull(message = "name不能为空")
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String publisher;

    /**
     * 出版时间
     */
    @Column(name = "publish_date")
    private String publishDate;

    /**
     * 版次
     */
    private Integer edition;

    /**
     * 所属国家
     */
    private String nation;

    /**
     * 类型（国外才有用到）
     * 例如：原版进口/影印/翻译/编译
     */
    private Integer type;

    /**
     * 用途（国外才有用到）
     * 例如：教材/教参/讲义/参考资料
     */
    private Integer purpose;

    /**
     * 教材等级
     */
    @Column(name = "level_id")
    @NotNull(message = "levelId不能为空")
    private Integer levelId;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 若教材版次更新，是否还需要征求意见
     */
    private Boolean renew;

    /**
     * 备注
     * 用来放选择本书的理由
     */
    private String remarks;

}
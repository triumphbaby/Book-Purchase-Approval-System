package com.ddu.goushushenpixitong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 学院
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Institute {
    /**
     * 学院编号
     */
    @Id
    private String id;

    /**
     * 学院名字
     */
    @NotNull(message = "name不能为空")
    private String name;

    /**
     * 备注
     */
    private String remarks;

}
package com.ddu.goushushenpixitong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 专业
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Major {
    /**
     * 专业编号
     */
    @NotNull(message = "id不能为空")
    @Id
    private String id;

    /**
     * 专业名称
     */
    @NotNull(message = "name不能为空")
    private String name;

    /**
     * 所属学院编号
     */
    @NotNull(message = "instituteId不能为空")
    @Column(name = "institute_id")
    private String instituteId;

    /**
     * 备注
     */
    private String remarks;

}
package com.ddu.goushushenpixitong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 人员
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Staff {
    @Id
    private String id;

    @NotNull(message = "name不能为空")
    private String name;

    @Column(name = "major_id")
    @NotNull(message = "major_id不能为空")
    private String majorId;

    @Column(name = "institute_id")
    @NotNull(message = "instituteId不能为空")
    private String instituteId;

    private String tel;

    private String remarks;

    private String pwd;

}
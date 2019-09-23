package com.ddu.goushushenpixitong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 审批表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Approval {
    /**
     * 课程用书id
     */
    @Id
    @Column(name = "subject_id")
    private Integer subjectId;

    /**
     * 教研室（课程组）审核意见 json
     */
    @Column(name = "option_lab")
    private String optionLab;

    /**
     * 开课教学单位意见 json
     */
    @Column(name = "option_unit")
    private String optionUnit;

    /**
     * 教务处备案 json
     */
    @Column(name = "option_dean")
    private String optionDean;

}
package com.ddu.goushushenpixitong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 课程用书
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Subject {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 课程编号
     */
    @Column(name = "course_id")
    @NotNull(message = "courseId不能为空")
    private String courseId;

    /**
     * 学期编号
     */
    @Column(name = "term_id")
    @NotNull(message = "termId不能为空")
    private Integer termId;

    /**
     * 图书编号
     */
    @Column(name = "book_id")
    @NotNull(message = "bookId不能为空")
    private String bookId;

    /**
     * 备注
     * 必修（required）或选修（elective）
     */
    private String remarks;

    /**
     * 学院编号
     */
    @Column(name = "institute_id")
    @NotNull(message = "instituteId不能为空")
    private String instituteId;

}
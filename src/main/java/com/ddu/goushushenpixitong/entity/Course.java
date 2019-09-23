package com.ddu.goushushenpixitong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Course {
    /**
     * 课程编号
     */
    @Id
    private String id;

    /**
     * 学期编号
     */
    @Id
    @Column(name = "term_id")
    @NotNull(message = "term_id不能为空")
    private Integer termId;

    /**
     * 课程名称
     */
    @NotNull(message = "name不能为空")
    private String name;

    /**
     * 学时
     */
    private Integer period;

    /**
     * 学分
     */
    private Integer credit;

    /**
     * 使用年级及专业
     * 例如：专业_年级_班级、专业_年级_班级、....
     * 单个：
     * 数字媒体技术_2_1-2
     * 多个：
     * 应用物理学_2_1-3、无人驾驶航空器系统工程_1_1-2、能源与动力工程_1_1-4、机械类_1_1-3、机器人工程_1_1-3
     */
    @Column(name = "usable_range")
    private String usableRange;

    /**
     * 学生数量
     */
    @Column(name = "student_num")
    private Integer studentNum;

    /**
     * 老师领用量
     */
    @Column(name = "teacher_num")
    private Integer teacherNum;

    /**
     * 负责人工号
     */
    @Column(name = "principal_id")
    @NotNull(message = "principalId不能为空")
    private String principalId;

    /**
     * 备注
     */
    private String remarks;

    public Course(String id, @NotNull(message = "term_id不能为空") Integer termId) {
        this.id = id;
        this.termId = termId;
    }

    /**
     * 将使用范围的字符串切分成专业、年级、班级
     *
     * @param usableRange
     * @return
     */
    public static String[] getUsableRangeElements(String usableRange) {
        String result[] = {"", "", ""};
        String[] cells = usableRange.split("、");
        for (int i = 0; i < cells.length; i++) {
            String[] elements = cells[i].split("_");
            result[0] += elements[0];
            result[1] += elements[1] + "年级";
            result[2] += elements[2] + "班";
            if (i < cells.length - 1) {
                result[0] += "、";
                result[1] += "、";
                result[2] += "、";
            }
        }
        return result;
    }

}
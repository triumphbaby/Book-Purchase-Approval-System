package com.ddu.goushushenpixitong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 教材征订计划表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BookPurchasingSchedule {
    /**
     * 序号
     */
    private Integer no;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 教材名称
     */
    private String bookName;

    /**
     * 书号
     */
    private String bookId;

    /**
     * 出版社/作者
     */
    private String PublisherAuther;

    /**
     * 出版时间
     */
    private String bookPublishDate;

    /**
     * 教材等级
     */
    private String bookLevelName;

    /**
     * 单价（元）
     */
    private Double price;

    /**
     * 使用年级、专业及方向
     */
    private String usableRange;

    /**
     * 学生数量
     */
    private Integer studentNum;

    /**
     * 教师领用量
     */
    private Integer teacherNum;

    /**
     * 选用人
     */
    private String principalName;

    /**
     * 联系电话
     */
    private String principalTel;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 学期名称
     * 例如：2017-2018学年第二学期
     */
    private String termName;

    /**
     * 开课单位
     * 例如：计算机学院
     */
    private String InstituteName;

    /**
     * 课程性质
     * 例如：必修课、选修课、实践课
     */
    private String courseCharacter;

    /**
     * 报送时间
     */
    private String SubmitTime;

    public static String[] getBookPurchasingScheduleInfo() {
        String[] list = new String[]{
                "序号", "课程名称", "教材名称", "书名", "出版社/作者",
                "出版时间", "教材等级", "单价(元)", "使用年级、专业及方向",
                "学生数量", "教师领用量", "选用人", "联系电话", "备注"
        };
        return list;
    }

}

package com.ddu.goushushenpixitong.util;

import com.alibaba.fastjson.JSONObject;
import com.ddu.goushushenpixitong.entity.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 教材选用审批表操作工具类
 */
public class ApprovalFormUtil {
    /**
     * 选中符号
     */
    private static final String CHECKED = "■";
    /**
     * 未选中符号
     */
    private static final String UNCHECKED = "□";

    private static final String NULL = "_______________";

    /**
     * 设置学期
     *
     * @param dataMap
     * @param termName
     */
    public static void setTerm(Map<String, String> dataMap, String termName) {
        dataMap.put("a1", termName);
    }

    /**
     * 设置开课教学单位
     *
     * @param dataMap
     * @param instituteName
     */
    public static void setInstitute(Map<String, String> dataMap, String instituteName) {
        dataMap.put("a2", instituteName);
    }

    /**
     * 设置课程名称
     *
     * @param dataMap
     * @param courseName
     */
    public static void setCourseName(Map<String, String> dataMap, String courseName) {
        dataMap.put("b1", courseName);
    }

    /**
     * 设置课程代码
     *
     * @param dataMap
     * @param courseId
     */
    public static void setCourseId(Map<String, String> dataMap, String courseId) {
        dataMap.put("b2", courseId);
    }

    /**
     * 设置课程性质
     *
     * @param dataMap
     * @param isRequired
     */
    public static void setCourseCharacter(Map<String, String> dataMap, Boolean isRequired) {
        if (isRequired) { //必修课
            dataMap.put("b3", CHECKED);
            dataMap.put("b4", UNCHECKED);
        } else { //选修课
            dataMap.put("b3", UNCHECKED);
            dataMap.put("b4", CHECKED);
        }
    }

    /**
     * 设置教材名称
     *
     * @param dataMap
     * @param bookName
     */
    public static void setBookName(Map<String, String> dataMap, String bookName) {
        dataMap.put("c1", bookName);
    }

    /**
     * 设置课程学时
     *
     * @param dataMap
     * @param coursePeriod
     */
    public static void setCoursePeriod(Map<String, String> dataMap, String coursePeriod) {
        dataMap.put("c2", coursePeriod);
    }

    /**
     * 设置课程学分
     *
     * @param dataMap
     * @param courseCredit
     */
    public static void setCourseCredit(Map<String, String> dataMap, String courseCredit) {
        dataMap.put("c3", courseCredit);
    }

    /**
     * 设置教材作者
     *
     * @param dataMap
     * @param bookAuthor
     */
    public static void setBookAuthor(Map<String, String> dataMap, String bookAuthor) {
        dataMap.put("d1", bookAuthor);
    }

    /**
     * 设置教材出版社
     *
     * @param dataMap
     * @param bookPublisher
     */
    public static void setBookPublisher(Map<String, String> dataMap, String bookPublisher) {
        dataMap.put("d2", bookPublisher);
    }

    /**
     * 设置教材编号
     *
     * @param dataMap
     * @param bookId
     */
    public static void setBookId(Map<String, String> dataMap, String bookId) {
        dataMap.put("d3", bookId);
    }

    /**
     * 设置教材出版时间
     * 例如：2014.04
     *
     * @param dataMap
     * @param bookPublishDate
     */
    public static void setBookPublishDate(Map<String, String> dataMap, String bookPublishDate) {
        dataMap.put("e1", bookPublishDate);
    }

    /**
     * 设置教材版次
     *
     * @param dataMap
     * @param bookEdition
     */
    public static void setBookEdition(Map<String, String> dataMap, String bookEdition) {
        dataMap.put("e2", bookEdition);
    }

    /**
     * 设置教材印刷时间
     * 例如：2014
     *
     * @param dataMap
     * @param bookPrintingDate
     */
    public static void setBookPrintingDate(Map<String, String> dataMap, String bookPrintingDate) {
        dataMap.put("e3", bookPrintingDate);
    }

    /**
     * 设置教材等级或类别
     *
     * @param dataMap
     * @param levelId
     * @param comment
     */
    public static void setBookLevel(Map<String, String> dataMap, Integer levelId, String comment) {
        switch (levelId) {
            case 1:
                dataMap.put("f1", CHECKED);
                dataMap.put("f2", UNCHECKED);
                dataMap.put("f3", UNCHECKED);
                dataMap.put("f4", UNCHECKED);
                dataMap.put("f5", UNCHECKED);
                dataMap.put("f6", NULL);
                break;
            case 2:
                dataMap.put("f1", UNCHECKED);
                dataMap.put("f2", CHECKED);
                dataMap.put("f3", UNCHECKED);
                dataMap.put("f4", UNCHECKED);
                dataMap.put("f5", UNCHECKED);
                dataMap.put("f6", NULL);
                break;
            case 3:
                dataMap.put("f1", UNCHECKED);
                dataMap.put("f2", UNCHECKED);
                dataMap.put("f3", CHECKED);
                dataMap.put("f4", UNCHECKED);
                dataMap.put("f5", UNCHECKED);
                dataMap.put("f6", NULL);
                break;
            case 4:
                dataMap.put("f1", UNCHECKED);
                dataMap.put("f2", UNCHECKED);
                dataMap.put("f3", UNCHECKED);
                dataMap.put("f4", CHECKED);
                dataMap.put("f5", UNCHECKED);
                dataMap.put("f6", NULL);
                break;
            case 5:
                dataMap.put("f1", UNCHECKED);
                dataMap.put("f2", UNCHECKED);
                dataMap.put("f3", UNCHECKED);
                dataMap.put("f4", UNCHECKED);
                dataMap.put("f5", CHECKED);
                dataMap.put("f6", comment);
                break;
        }
    }

    /**
     * 设置使用专业
     *
     * @param dataMap
     * @param usableMajor
     */
    public static void setUsableMajor(Map<String, String> dataMap, String usableMajor) {
        dataMap.put("g1", usableMajor);
    }

    /**
     * 设置使用年级
     *
     * @param dataMap
     * @param usableGrade
     */
    public static void setUsableGrade(Map<String, String> dataMap, String usableGrade) {
        dataMap.put("g2", usableGrade);
    }

    /**
     * 设置使用班级
     *
     * @param dataMap
     * @param usableClass
     */
    public static void setUsableClass(Map<String, String> dataMap, String usableClass) {
        dataMap.put("g3", usableClass);
    }

    /**
     * 设置使用学期
     *
     * @param dataMap
     * @param usableTerm
     */
    public static void setUsableTerm(Map<String, String> dataMap, String usableTerm) {
        dataMap.put("g4", usableTerm);
    }

    /**
     * 设置选用本教材理由
     *
     * @param dataMap
     * @param reasons
     */
    public static void setReasonForBook(Map<String, String> dataMap, String reasons) {
        dataMap.put("h1", reasons);
    }

    /**
     * 若教材更新，是否还需要征求意见
     *
     * @param dataMap
     * @param isRenew
     */
    public static void setRenew(Map<String, String> dataMap, Boolean isRenew) {
        //renew为true是指教材版次更新，无需征求意见
        if (isRenew) {
            dataMap.put("h2", UNCHECKED);
            dataMap.put("h3", CHECKED);
        } else {
            dataMap.put("h2", CHECKED);
            dataMap.put("h3", UNCHECKED);
        }
    }

    /**
     * 设置授课教师签名
     *
     * @param dataMap
     * @param date
     */
    public static void setSignatureDateOfTeacher(Map<String, String> dataMap, String date) {
        dataMap.put("h4", date);
    }

    /**
     * 设置教研室审核结果
     *
     * @param dataMap
     * @param jsonObjects
     */
    public static void setLaboratoryOpinions(Map<String, String> dataMap, JSONObject[] jsonObjects) {
        int i = 1, j = 1;
        for (JSONObject jo : jsonObjects) {
            dataMap.put("ii" + i++, jo.getString("content"));
            if (jo.getString("opinion").equals("yes")) {
                dataMap.put("i" + j++, CHECKED);
                dataMap.put("i" + j++, UNCHECKED);
            } else {
                dataMap.put("i" + j++, UNCHECKED);
                dataMap.put("i" + j++, CHECKED);
            }
        }
    }

    /**
     * 设置教研室签名
     *
     * @param dataMap
     * @param date
     */
    public static void setSignatureDateOfLab(Map<String, String> dataMap, String date) {
        dataMap.put("i13", date);
    }

    /**
     * 设置开课教学单位审核结果
     *
     * @param dataMap
     * @param jsonObjects
     */
    public static void setTeachingUnitOpinions(Map<String, String> dataMap, JSONObject[] jsonObjects) {
        int i = 1, j = 1;
        for (JSONObject jo : jsonObjects) {
            dataMap.put("jj" + i++, jo.getString("content"));
            if (jo.getString("opinion").equals("yes")) {
                dataMap.put("j" + j++, CHECKED);
                dataMap.put("j" + j++, UNCHECKED);
            } else {
                dataMap.put("j" + j++, UNCHECKED);
                dataMap.put("j" + j++, CHECKED);
            }
        }
    }

    /**
     * 设置开课教学单位签名
     *
     * @param dataMap
     * @param date
     */
    public static void setSignatureDateOfUnit(Map<String, String> dataMap, String date) {
        dataMap.put("j3", date);
    }

    /**
     * 设置教务处审核结果
     *
     * @param dataMap
     * @param jsonObjects
     */
    public static void setDeanOfficeOpinions(Map<String, String> dataMap, JSONObject[] jsonObjects) {
        int i = 1, j = 1;
        for (JSONObject jo : jsonObjects) {
            dataMap.put("kk" + i++, jo.getString("content"));
            if (jo.getString("opinion").equals("yes")) {
                dataMap.put("k" + j++, CHECKED);
                dataMap.put("k" + j++, UNCHECKED);
            } else {
                dataMap.put("k" + j++, UNCHECKED);
                dataMap.put("k" + j++, CHECKED);
            }
        }
    }

    /**
     * 设置教务处签名
     *
     * @param dataMap
     * @param date
     */
    public static void setSignatureDateOfDean(Map<String, String> dataMap, String date) {
        dataMap.put("k5", date);
    }

    /**
     * 快速装配审核表数据
     *
     * @param subject   课程用书
     * @param term      学期
     * @param course    课程
     * @param book      书本
     * @param institute 学院
     * @param level     教材等级
     * @return
     */
    public static Map<String, String> prepareDataQuick(Subject subject, Term term, Course course, Book book, Institute institute, Level level) {
        Map<String, String> dataMap = new HashMap<String, String>();

        ApprovalFormUtil.setTerm(dataMap, term.getName());
        ApprovalFormUtil.setInstitute(dataMap, institute.getName());
        ApprovalFormUtil.setCourseName(dataMap, course.getName());
        ApprovalFormUtil.setCourseId(dataMap, course.getId());
        ApprovalFormUtil.setCourseCharacter(dataMap, subject.getRemarks().equals("required") ? true : false);
        ApprovalFormUtil.setBookName(dataMap, book.getName());
        ApprovalFormUtil.setCoursePeriod(dataMap, course.getPeriod() + "");
        ApprovalFormUtil.setCourseCredit(dataMap, course.getCredit() + "");
        ApprovalFormUtil.setBookAuthor(dataMap, book.getAuthor());
        ApprovalFormUtil.setBookPublisher(dataMap, book.getPublisher());
        ApprovalFormUtil.setBookId(dataMap, book.getId());
        ApprovalFormUtil.setBookPublishDate(dataMap, book.getPublishDate());
        ApprovalFormUtil.setBookEdition(dataMap, book.getEdition() + "");
        ApprovalFormUtil.setBookPrintingDate(dataMap, book.getPublishDate().split("\\.")[0]);
        ApprovalFormUtil.setBookLevel(dataMap, Integer.parseInt(level.getRemarks()), level.getName());
        ApprovalFormUtil.setUsableMajor(dataMap, Course.getUsableRangeElements(course.getUsableRange())[0]);
        ApprovalFormUtil.setUsableGrade(dataMap, Course.getUsableRangeElements(course.getUsableRange())[1]);
        ApprovalFormUtil.setUsableClass(dataMap, Course.getUsableRangeElements(course.getUsableRange())[2]);
        ApprovalFormUtil.setUsableTerm(dataMap, Term.getAbbreviation(term.getName()));
        ApprovalFormUtil.setReasonForBook(dataMap, book.getRemarks());
        ApprovalFormUtil.setRenew(dataMap, book.getRenew());

        return dataMap;
    }

}

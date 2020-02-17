package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Book;
import com.ddu.goushushenpixitong.entity.Subject;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SubjectMapper extends Mapper<Subject> {

    @Select("SELECT * FROM SUBJECT WHERE institute_id = #{insititudeId}")
    List<Subject> getSubjectByInstituteId(String insititudeId);

    @Select("<script>" +
            "SELECT b.`author`,b.`edition`,b.`id`,b.`level_id`,b.`name`,b.`nation`,b.`price`,\n" +
            "\tb.`publisher`,b.`publish_date`,b.`purpose`,b.`remarks`,b.`renew`,b.`type`\n" +
            "FROM `subject` \n" +
            "LEFT JOIN book AS b\n" +
            "\tON subject.`book_id` = b.`id`\n" +
            "LEFT JOIN term \n" +
            "\tON term.`id` = subject.`term_id`\n" +
            "LEFT JOIN course\n" +
            "\tON course.`id` = subject.`course_id`\n" +
            "WHERE 1 =1 " +
            "<if test = 'termName != null'> AND term.`name` LIKE CONCAT(CONCAT('%', #{termName}), '%') </if>" +
            "<if test = 'courseName != null'> AND course.`name` LIKE CONCAT(CONCAT('%', #{courseName}), '%') </if>" +
            "<if test = 'bookName != null'> AND b.`name` LIKE CONCAT(CONCAT('%', #{bookName}), '%') </if>" +
            "</script> ")
    List<Book> fuzzySearch(String bookName,String termName,String courseName);


}
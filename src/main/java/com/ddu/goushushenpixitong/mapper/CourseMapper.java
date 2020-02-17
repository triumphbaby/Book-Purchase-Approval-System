package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface CourseMapper extends Mapper<Course> {

    /**
     * 根据课程id删除课程
     * @param id
     * @return
     */
    @Delete("delete  from course where id = #{id}")
    int deleteById(String id);


    /**
     * 根据课程id删除课程
     * @param id
     * @return
     */
    @Select(" SELECT * FROM course WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "termId", column = "term_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "period", column = "period"),
            @Result(property = "credit", column = "credit"),
            @Result(property = "usableRange", column = "usable_range"),
            @Result(property = "studentNum", column = "student_num"),
            @Result(property = "teacherNum", column = "teacher_num"),
            @Result(property = "principalId", column = "principal_id"),
            @Result(property = "remarks", column = "remarks")
    })
    Course findById(String id);
}
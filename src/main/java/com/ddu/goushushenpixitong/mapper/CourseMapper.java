package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Course;
import org.apache.ibatis.annotations.Delete;
import tk.mybatis.mapper.common.Mapper;

public interface CourseMapper extends Mapper<Course> {

    /**
     * 根据课程id删除课程
     * @param id
     * @return
     */
    @Delete("delete  from course where id = #{id}")
    int deleteById(String id);
}
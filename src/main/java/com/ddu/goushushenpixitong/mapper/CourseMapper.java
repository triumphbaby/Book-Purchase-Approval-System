package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Course;
import org.apache.ibatis.annotations.Delete;
import tk.mybatis.mapper.common.Mapper;

public interface CourseMapper extends Mapper<Course> {

    @Delete("delete  from course where id = #{id}")
    public int deleteById(String id);
}
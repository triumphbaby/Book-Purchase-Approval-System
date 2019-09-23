package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Course;

import java.util.List;

public interface CourseService {
    /**
     * 添加课程
     *
     * @param course
     * @return
     */
    Boolean add(Course course);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Boolean remove(String id);

    /**
     * 修改
     *
     * @param course
     * @return
     */
    Boolean modify(Course course);

    /**
     * 获取课程列表
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<Course> findCoursesByPage(int currentPage, int pageSize);

    /**
     * 查询单条记录
     *
     * @param id
     * @param termId
     * @return
     */
    Course findById(String id, Integer termId);
}

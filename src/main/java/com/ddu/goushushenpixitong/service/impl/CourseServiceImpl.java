package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Course;
import com.ddu.goushushenpixitong.mapper.CourseMapper;
import com.ddu.goushushenpixitong.service.CourseService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final static int SUCCESS = 1;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Boolean add(Course course) {
        return courseMapper.insertSelective(course) == SUCCESS;
    }

    @Override
    public Boolean remove(String id) {
        return courseMapper.deleteById(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Course course) {
        return courseMapper.updateByPrimaryKey(course) == SUCCESS;
    }

    @Override
    public List<Course> findCoursesByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Course> allStaffs = courseMapper.selectAll();
        int countNums = courseMapper.selectCount(new Course());
        PageBean<Course> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allStaffs);
        return pageData.getItems();
    }

    @Override
    public Course findByIdAndTermId(String id, Integer termId) {
        return courseMapper.select(new Course(id, termId)).get(0);
    }

    @Override
    public Course findById(String id) {
        return courseMapper.findById(id);
    }
}

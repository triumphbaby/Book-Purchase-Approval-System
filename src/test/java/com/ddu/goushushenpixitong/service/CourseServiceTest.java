package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Course;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseServiceTest extends BaseTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void testFindById() {
        String id = "02170001";
        Integer termId = 1;
        System.out.println(courseService.findByIdAndTermId(id, termId));
    }

    @Test
    public void testAdd(){
        Course c = new Course("1002",3,"asd",null,null,null,null,null,"1001",null);
        courseService.add(c);
    }

}

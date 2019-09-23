package com.ddu.goushushenpixitong.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseServiceTest extends BaseTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void testFindById(){
        String id = "02170001";
        Integer termId = 1;
        System.out.println(courseService.findById(id,termId));
    }

}

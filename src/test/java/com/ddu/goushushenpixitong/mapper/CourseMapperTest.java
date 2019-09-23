package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Course;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseMapperTest extends BaseTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void testGetUsableMajor(){
        Course course01 = courseMapper.select(new Course("02170001",1)).get(0);
        Course course02 = courseMapper.select(new Course("02170002",1)).get(0);

        for (String s : Course.getUsableRangeElements(course01.getUsableRange())) {
            System.out.println(s);
        }
        for (String s : Course.getUsableRangeElements(course02.getUsableRange())) {
            System.out.println(s);
        }
    }

    @Test
    public void testSelect(){
        String id = "02170001";
        Integer termId = 1;

        System.out.println(courseMapper.select(new Course(id,termId)).get(0));
        System.out.println(courseMapper.selectCount(new Course(id,termId)));

    }

}

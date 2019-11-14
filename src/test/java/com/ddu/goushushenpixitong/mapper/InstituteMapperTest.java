package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Institute;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class InstituteMapperTest extends BaseTest {

    @Autowired
    private InstituteMapper instituteMapper;

    @Test
    public void testSelectOne() {

    }

    @Test
    public void testSelect() {

    }

    @Test
    public void testSelectAll() {

    }

    @Test
    public void testSelectCount() {

    }

    @Test
    public void testSelectByPrimaryKey() {

    }

    @Test
    public void testExistsWithPrimaryKey() {

    }

    @Test
    public void testInsert() {
//        Institute major = new Institute("institute01","test");
//        System.out.println(instituteMapper.insert(major));
    }

    @Test
    public void testInsertSelective() {
        Institute major = new Institute(null, "institute01", "test");
        System.out.println(instituteMapper.insertSelective(major));
    }

    @Test
    public void testUpdateByPrimaryKey() {

    }

    @Test
    public void testUpdateByPrimaryKeySelective() {

    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testDeleteByPrimaryKey() {

    }

}

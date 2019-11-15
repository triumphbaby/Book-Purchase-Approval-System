package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Level;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LevelServiceTest extends BaseTest {

    @Autowired
    private LevelService levelService;

    @Test
    public void testAdd() {
        Level level = new Level(null, "test01", null);
        System.out.println(levelService.add(level));
    }

}

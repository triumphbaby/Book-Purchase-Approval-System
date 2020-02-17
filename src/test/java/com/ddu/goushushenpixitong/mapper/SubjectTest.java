package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Book;
import com.ddu.goushushenpixitong.entity.Level;
import com.ddu.goushushenpixitong.service.BaseTest;
import com.ddu.goushushenpixitong.service.LevelService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubjectTest extends BaseTest {

    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * 测试模糊搜索书本
     */
    @Test
    public void test() {
        List<Book> books = subjectMapper.fuzzySearch("计算机", null, null);
        for (Book book:books){
            System.out.println(book);
        }
    }

}

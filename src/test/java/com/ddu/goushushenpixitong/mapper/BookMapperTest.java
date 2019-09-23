package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookMapperTest extends BaseTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testSplit() {
        Book book = bookMapper.selectByPrimaryKey("9787111461371");
//        System.out.println(book.getPublishDate().split(".")); //错误写法
//        String data = "2014.04";
        String date = book.getPublishDate();
        String[] strArr = date.split("\\.");
        for (int i = 0; i < strArr.length; i++) {
            System.out.println("------");
            System.out.println(strArr[i]);
        }

    }

}

package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Book;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookMapper extends Mapper<Book> {

    /**
     * 模糊搜索书本
     * @param string 模糊搜索条件
     * @return
     */
    @Select("SELECT * FROM book WHERE NAME LIKE CONCAT(CONCAT('%', #{string}), '%') ")
    List<Book> getByLike(String string);

}
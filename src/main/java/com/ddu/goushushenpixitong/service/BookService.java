package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * 添加
     *
     * @param book
     * @return
     */
    Boolean add(Book book);

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
     * @param book
     * @return
     */
    Boolean modify(Book book);

    /**
     * 分页获取书本信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<Book> findBooksByPage(int currentPage, int pageSize);

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    Book findById(String id);

    /**
     * 通过模糊搜索获取书本
     * @param string  模糊搜索的条件
     * @return
     */
    List<Book> findBookByLike(String string);

}

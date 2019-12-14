package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Book;
import com.ddu.goushushenpixitong.mapper.BookMapper;
import com.ddu.goushushenpixitong.service.BookService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final static int SUCCESS = 1;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Boolean add(Book book) {
        return bookMapper.insertSelective(book) == SUCCESS;
    }

    @Override
    public Boolean remove(String id) {
        return bookMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Book book) {
        return bookMapper.updateByPrimaryKey(book) == SUCCESS;
    }

    @Override
    public List<Book> findBooksByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Book> allBooks = bookMapper.selectAll();
        int countNums = bookMapper.selectCount(new Book());
        PageBean<Book> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allBooks);
        return pageData.getItems();
    }

    @Override
    public Book findById(String id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> findBookByLike(String string) {
        return bookMapper.getByLike(string);
    }
}

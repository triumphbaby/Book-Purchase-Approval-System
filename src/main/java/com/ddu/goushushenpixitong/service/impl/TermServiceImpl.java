package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Term;
import com.ddu.goushushenpixitong.mapper.TermMapper;
import com.ddu.goushushenpixitong.service.TermService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermServiceImpl implements TermService {

    private final static int SUCCESS = 1;

    @Autowired
    private TermMapper termMapper;

    @Override
    public Boolean add(Term term) {
        return termMapper.insertSelective(term) == SUCCESS;
    }

    @Override
    public Boolean remove(Integer id) {
        return termMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Term term) {
        return termMapper.updateByPrimaryKeySelective(term) == SUCCESS;
    }

    @Override
    public List<Term> findTermByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Term> allTerms = termMapper.selectAll();
        int countNums = termMapper.selectCount(new Term());
        PageBean<Term> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allTerms);
        return pageData.getItems();
    }

    @Override
    public Term findById(Integer id) {
        return termMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer findIdByName(String name){
     return termMapper.selectIdByname(name);
    }

}

package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Subject;
import com.ddu.goushushenpixitong.mapper.SubjectMapper;
import com.ddu.goushushenpixitong.service.SubjectService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final static int SUCCESS = 1;

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public Boolean add(Subject subject) {
        return subjectMapper.insertSelective(subject) == SUCCESS;
    }

    @Override
    public Boolean remove(Integer id) {
        return subjectMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Subject subject) {
        return subjectMapper.updateByPrimaryKey(subject) == SUCCESS;
    }

    @Override
    public List<Subject> findSubjectsByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Subject> allSubjects = subjectMapper.selectAll();
        int countNums = subjectMapper.selectCount(new Subject());
        PageBean<Subject> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allSubjects);
        return pageData.getItems();
    }

    @Override
    public Subject findById(Integer id) {
        return subjectMapper.selectByPrimaryKey(id);
    }
}

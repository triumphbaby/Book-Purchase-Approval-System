package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Major;
import com.ddu.goushushenpixitong.mapper.MajorMapper;
import com.ddu.goushushenpixitong.service.MajorService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    private final static int SUCCESS = 1;

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public Boolean add(Major major) {
        return majorMapper.insertSelective(major) == SUCCESS;
    }

    @Override
    public Boolean remove(String id) {
        return majorMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Major major) {
        return majorMapper.updateByPrimaryKeySelective(major) == SUCCESS;
    }

    @Override
    public List<Major> findMajorByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Major> allCourses = majorMapper.selectAll();
        int countNums = majorMapper.selectCount(new Major());
        PageBean<Major> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allCourses);
        return pageData.getItems();
    }

    @Override
    public Major findById(String id) {
        return majorMapper.selectByPrimaryKey(id);
    }
}

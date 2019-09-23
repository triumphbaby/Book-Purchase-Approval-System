package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Institute;
import com.ddu.goushushenpixitong.mapper.InstituteMapper;
import com.ddu.goushushenpixitong.service.InstituteService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService {

    private final static int SUCCESS = 1;

    @Autowired
    private InstituteMapper instituteMapper;

    @Override
    public Boolean add(Institute institute) {
        try {
            return instituteMapper.insertSelective(institute) == SUCCESS;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean remove(String id) {
        return instituteMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Institute institute) {
        return instituteMapper.updateByPrimaryKey(institute) == SUCCESS;
    }

    @Override
    public List<Institute> findInstituteByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Institute> allInstitute = instituteMapper.selectAll();
        int countNums = instituteMapper.selectCount(new Institute());
        PageBean<Institute> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allInstitute);
        return pageData.getItems();
    }

    @Override
    public Institute findById(String id) {
        return instituteMapper.selectByPrimaryKey(id);
    }
}

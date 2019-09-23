package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.TeachingUnit;
import com.ddu.goushushenpixitong.mapper.TeachingUnitMapper;
import com.ddu.goushushenpixitong.service.TeachingUnitService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachingUnitServiceImpl implements TeachingUnitService {

    private final static int SUCCESS = 1;

    @Autowired
    private TeachingUnitMapper teachingUnitMapper;

    @Override
    public Boolean add(TeachingUnit teachingUnit) {
        try {
            return teachingUnitMapper.insertSelective(teachingUnit) == SUCCESS;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean remove(Integer id) {
        return teachingUnitMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(TeachingUnit teachingUnit) {
        return teachingUnitMapper.updateByPrimaryKey(teachingUnit) == SUCCESS;
    }

    @Override
    public List<TeachingUnit> findTeachingUnitByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<TeachingUnit> allTeachingUnit = teachingUnitMapper.selectAll();
        int countNums = teachingUnitMapper.selectCount(new TeachingUnit());
        PageBean<TeachingUnit> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allTeachingUnit);
        return pageData.getItems();
    }

    @Override
    public TeachingUnit findById(Integer id) {
        return teachingUnitMapper.selectByPrimaryKey(id);
    }
}

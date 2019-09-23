package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Laboratory;
import com.ddu.goushushenpixitong.mapper.LaboratoryMapper;
import com.ddu.goushushenpixitong.service.LaboratoryService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {

    private final static int SUCCESS = 1;

    @Autowired
    private LaboratoryMapper laboratoryMapper;

    @Override
    public Boolean add(Laboratory laboratory) {
        try {
            return laboratoryMapper.insertSelective(laboratory) == SUCCESS;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean remove(Integer id) {
        return laboratoryMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Laboratory laboratory) {
        return laboratoryMapper.updateByPrimaryKey(laboratory) == SUCCESS;
    }

    @Override
    public List<Laboratory> findLaboratoryByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Laboratory> allLaboratory = laboratoryMapper.selectAll();
        int countNums = laboratoryMapper.selectCount(new Laboratory());
        PageBean<Laboratory> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allLaboratory);
        return pageData.getItems();
    }

    @Override
    public Laboratory findById(Integer id) {
        return laboratoryMapper.selectByPrimaryKey(id);
    }

}

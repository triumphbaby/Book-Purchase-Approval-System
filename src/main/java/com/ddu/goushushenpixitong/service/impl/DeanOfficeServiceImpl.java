package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.DeanOffice;
import com.ddu.goushushenpixitong.mapper.DeanOfficeMapper;
import com.ddu.goushushenpixitong.service.DeanOfficeService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeanOfficeServiceImpl implements DeanOfficeService {

    private final static int SUCCESS = 1;

    @Autowired
    private DeanOfficeMapper deanOfficeMapper;

    @Override
    public Boolean add(DeanOffice deanOffice) {
        try {
            return deanOfficeMapper.insertSelective(deanOffice) == SUCCESS;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean remove(Integer id) {
        return deanOfficeMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(DeanOffice deanOffice) {
        return deanOfficeMapper.updateByPrimaryKey(deanOffice) == SUCCESS;
    }

    @Override
    public List<DeanOffice> findDeanOfficeByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<DeanOffice> allDeanOffice = deanOfficeMapper.selectAll();
        int countNums = deanOfficeMapper.selectCount(new DeanOffice());
        PageBean<DeanOffice> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allDeanOffice);
        return pageData.getItems();
    }

    @Override
    public DeanOffice findById(Integer id) {
        return deanOfficeMapper.selectByPrimaryKey(id);
    }
}

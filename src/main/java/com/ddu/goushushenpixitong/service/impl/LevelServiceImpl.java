package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Level;
import com.ddu.goushushenpixitong.mapper.LevelMapper;
import com.ddu.goushushenpixitong.service.LevelService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    private final static int SUCCESS = 1;

    @Autowired
    private LevelMapper levelMapper;

    @Override
    public Boolean add(Level level) {
        try {
            return levelMapper.insertSelective(level) == SUCCESS;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean remove(Integer id) {
        return levelMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Level level) {
        return levelMapper.updateByPrimaryKeySelective(level) == SUCCESS;
    }

    @Override
    public List<Level> findLevelByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Level> allLevel = levelMapper.selectAll();
        int countNums = levelMapper.selectCount(new Level());
        PageBean<Level> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allLevel);
        return pageData.getItems();
    }

    @Override
    public Level findById(Integer id) {
        return levelMapper.selectByPrimaryKey(id);
    }
}

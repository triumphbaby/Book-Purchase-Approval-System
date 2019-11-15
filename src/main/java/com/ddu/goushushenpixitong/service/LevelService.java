package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Level;

import java.util.List;

public interface LevelService {
    /**
     * 添加等级记录
     *
     * @param level
     * @return
     */
    Boolean add(Level level);

    /**
     * 删除等级记录
     *
     * @param id
     * @return
     */
    Boolean remove(Integer id);

    /**
     * 修改
     *
     * @param level
     * @return
     */
    Boolean modify(Level level);

    /**
     * 获取所有等级记录
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Level> findLevelByPage(int currentPage, int pageSize);

    /**
     * 获取单条记录
     *
     * @param id
     * @return
     */
    Level findById(Integer id);


}

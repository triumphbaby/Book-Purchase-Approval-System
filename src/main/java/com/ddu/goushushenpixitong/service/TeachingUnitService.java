package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.TeachingUnit;

import java.util.List;

public interface TeachingUnitService {
    /**
     * 添加开课教学单位审核条目
     *
     * @param teachingUnit
     * @return
     */
    Boolean add(TeachingUnit teachingUnit);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Boolean remove(Integer id);

    /**
     * 修改
     *
     * @param teachingUnit
     * @return
     */
    Boolean modify(TeachingUnit teachingUnit);

    /**
     * 获取所有开课教学单位审核内容
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<TeachingUnit> findTeachingUnitByPage(int currentPage, int pageSize);

    /**
     * 查询某个审核内容
     *
     * @param id
     * @return
     */
    TeachingUnit findById(Integer id);
}

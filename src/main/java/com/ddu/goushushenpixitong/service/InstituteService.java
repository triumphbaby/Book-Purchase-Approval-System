package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Institute;

import java.util.List;

public interface InstituteService {
    /**
     * 添加学院
     *
     * @param institute
     * @return
     */
    Boolean add(Institute institute);

    /**
     * 删除学院
     *
     * @param id 学院编号
     * @return
     */
    Boolean remove(String id);

    /**
     * 更新学院
     *
     * @param institute
     * @return
     */
    Boolean modify(Institute institute);

    /**
     * 获取学院列表
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    public List<Institute> findInstituteByPage(int currentPage, int pageSize);

    /**
     * 用学院编号查出学院
     *
     * @param id
     * @return
     */
    Institute findById(String id);

}

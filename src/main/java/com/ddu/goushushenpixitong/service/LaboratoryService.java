package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Laboratory;

import java.util.List;

public interface LaboratoryService {
    /**
     * 添加教研室审核内容
     *
     * @param laboratory
     * @return
     */
    Boolean add(Laboratory laboratory);

    /**
     * 删除教研室审核内容
     *
     * @param id
     * @return
     */
    Boolean remove(Integer id);

    /**
     * 修改
     *
     * @param laboratory
     * @return
     */
    Boolean modify(Laboratory laboratory);

    /**
     * 获取所有审核内容
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Laboratory> findLaboratoryByPage(int currentPage, int pageSize);

    /**
     * 查询某个审核内容
     *
     * @param id
     * @return
     */
    Laboratory findById(Integer id);

}

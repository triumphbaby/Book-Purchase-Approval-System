package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.DeanOffice;

import java.util.List;

public interface DeanOfficeService {
    /**
     * 添加教务处审核条目
     *
     * @param deanOffice
     * @return
     */
    Boolean add(DeanOffice deanOffice);

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
     * @param deanOffice
     * @return
     */
    Boolean modify(DeanOffice deanOffice);

    /**
     * 获取所有开课教学单位审核内容
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<DeanOffice> findDeanOfficeByPage(int currentPage, int pageSize);

    /**
     * 查询某个审核内容
     *
     * @param id
     * @return
     */
    DeanOffice findById(Integer id);
}

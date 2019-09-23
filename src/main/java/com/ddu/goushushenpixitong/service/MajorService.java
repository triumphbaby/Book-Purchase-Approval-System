package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Major;

import java.util.List;

public interface MajorService {
    /**
     * 添加专业
     *
     * @param major
     * @return
     */
    Boolean add(Major major);

    /**
     * 删除专业
     *
     * @param id 专业编号
     * @return
     */
    Boolean remove(String id);

    /**
     * 更新专业信息
     *
     * @param major
     * @return
     */
    Boolean modify(Major major);

    /**
     * 分页获取专业记录
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<Major> findMajorByPage(int currentPage, int pageSize);

    /**
     * 用专业编号查专业信息
     *
     * @param id 专业编号
     * @return
     */
    Major findById(String id);
}

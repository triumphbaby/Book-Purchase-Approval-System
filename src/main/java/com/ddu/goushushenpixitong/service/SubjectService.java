package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Subject;

import java.util.List;

public interface SubjectService {
    /**
     * 添加课程用书
     *
     * @param subject
     * @return
     */
    Boolean add(Subject subject);

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
     * @param subject
     * @return
     */
    Boolean modify(Subject subject);

    /**
     * 获取学期列表
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<Subject> findSubjectsByPage(int currentPage, int pageSize);

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    Subject findById(Integer id);
}

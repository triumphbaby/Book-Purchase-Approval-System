package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Term;

import java.util.List;

public interface TermService {
    /**
     * 添加学期
     *
     * @param term
     * @return
     */
    Boolean add(Term term);

    /**
     * 删除学期记录
     *
     * @param id
     * @return
     */
    Boolean remove(Integer id);

    /**
     * 修改
     *
     * @param term
     * @return
     */
    Boolean modify(Term term);

    /**
     * 获取学期列表
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<Term> findTermByPage(int currentPage, int pageSize);

    /**
     * 查找单条记录
     *
     * @param id
     * @return
     */
    Term findById(Integer id);

    /**
     * 学年名字获取学期标识
     * @return
     */
    Integer findIdByName(String name);
}

package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Term;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TermMapper extends Mapper<Term> {

    /**
     * 根据学期名获取学期标识
     * @param name 学期名  2017-2018
     * @return
     */
    @Select("select id from term where  name = {name}")
    public Integer selectIdByname(String name);

}
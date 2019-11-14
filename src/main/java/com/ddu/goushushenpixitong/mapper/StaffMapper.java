package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Staff;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface StaffMapper extends Mapper<Staff> {


    /**
     * 根据教师名称获取id
     *
     * @param name
     * @return
     */
    @Select("select id from staff where name = #{name} ")
    public String selectIdByName(String name);
}
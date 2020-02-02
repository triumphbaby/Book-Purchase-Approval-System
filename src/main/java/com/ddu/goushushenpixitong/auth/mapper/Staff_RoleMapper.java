package com.ddu.goushushenpixitong.auth.mapper;

import com.ddu.goushushenpixitong.auth.entity.Staff_Role;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface Staff_RoleMapper extends Mapper<Staff_Role> {
    /**
     * 根据userId查询RoleId
     * @param staffId 用户id
     * @return 角色id
     */
    @Select("SELECT * FROM staff_role WHERE userId =#{staffId}")
    List<Integer> getRoleIdByUserId(String staffId);
}
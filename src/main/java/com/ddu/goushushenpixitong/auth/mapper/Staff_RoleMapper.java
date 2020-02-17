package com.ddu.goushushenpixitong.auth.mapper;

import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Staff_Role;
import org.apache.ibatis.annotations.*;
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

    /**
     * 为员工添加角色   默认方法会使staff_role变为staff__role导致报错 需重写
     * @param staff_role
     * @return
     */
    @Override
    @Insert("INSERT INTO staff_role  ( id,staff_id,role_id ) " +
            "VALUES( #{id},#{staffId},#{roleId} )")
    int insert(Staff_Role staff_role);


    /**
     * 根据id删除 默认方法会使staff_role变为staff__role导致报错 需重写
     * @param o  id
     * @return
     */
    @Override
    @Delete("DELETE FROM staff_role WHERE id = #{o}")
    int deleteByPrimaryKey(Object o);

    /**
     * 获取所有人员的角色
     * @return
     */
    @Select("SELECT staff.`id`,staff.`name`,role.`type` " +
            "FROM staff,staff_role,role " +
            "WHERE staff.`id`=staff_role.`staff_id` AND staff_role.`role_id` = role.`id` ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "role", column = "type"),
    })
    List<AuthDAO> getAllStaffRole();

    /**
     * 获取某个人员的角色
     * @param staffId 人员id
     * @return
     */
    @Select("SELECT staff.`id`,staff.`name`,role.`type` " +
            "FROM staff,staff_role,role " +
            "WHERE staff.`id`=staff_role.`staff_id` AND staff_role.`role_id` = role.`id` " +
            "AND staff.`id`=#{staffId} ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "role", column = "type"),
    })
    List<AuthDAO> getRolesByStaffId(String staffId);


}
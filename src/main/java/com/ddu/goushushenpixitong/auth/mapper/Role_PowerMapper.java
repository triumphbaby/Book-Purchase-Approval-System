package com.ddu.goushushenpixitong.auth.mapper;

import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Role;
import com.ddu.goushushenpixitong.auth.entity.Role_Power;
import com.ddu.goushushenpixitong.auth.entity.Staff_Role;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface Role_PowerMapper extends Mapper<Role_Power> {
    /**
     * 根据roleId查询对应的powerId
     * @param roleId 角色id
     * @return 权限id
     */
    @Select("SELECT * FROM role_power WHERE roleId = #{roleId}")
    List<Integer> getPowerByRoleId(Integer roleId);



    /**
     * 为角色添加权限   默认方法会使role_power变为role__power导致报错 需重写
     * @param role_power
     * @return
     */
    @Override
    @Insert("INSERT INTO role_power  ( id,role_id,powr_id ) " +
            "VALUES( #{id},#{roleId},#{powerId} )")
    int insert(Role_Power role_power);


    /**
     * 根据id删除 默认方法会使role_power变为role__power导致报错 需重写
     * @param o  id
     * @return
     */
    @Override
    @Delete("DELETE FROM role_power WHERE id = #{o}")
    int deleteByPrimaryKey(Object o);

    /**
     * 获取所有人员的权限
     * @return
     */
    @Select("SELECT staff.`id`,staff.`name`,power.`powerName`" +
            "FROM staff,staff_role,role,role_power,`power`" +
            "WHERE staff.`id`=staff_role.`staff_id` AND staff_role.`role_id` = role.`id` AND role.`id` = role_power.`role_id` AND role_power.`powr_id` = power.`id`"
    )
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "role", column = "type"),
            @Result(property = "power", column = "powerName"),
    })
    List<AuthDAO> getAllStaffPower();

    /**
     * 获取某个成员的权限
     * @return
     */
    @Select("SELECT staff.`id`,staff.`name`,power.`powerName`" +
            "FROM staff,staff_role,role,role_power,`power`" +
            "WHERE staff.`id`=staff_role.`staff_id` AND staff_role.`role_id` = role.`id` AND role.`id` = role_power.`role_id` AND role_power.`powr_id` = power.`id`" +
            "AND staff.`id` = #{staffId}"
    )
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "role", column = "type"),
            @Result(property = "power", column = "powerName"),
    })
    List<AuthDAO> getStaffPower(String staffId);
}
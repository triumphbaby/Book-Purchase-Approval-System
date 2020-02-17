package com.ddu.goushushenpixitong.auth.mapper;

import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-02-02 02
 */
public interface AuthMapper {

    /**
     * 获取所有人员的角色和权限
     * @return
     */
    @Select("SELECT staff.`id`,staff.`name`,role.`type`,power.`powerName`" +
            "FROM staff,staff_role,role,role_power,`power`" +
            "WHERE staff.`id`=staff_role.`staff_id` AND staff_role.`role_id` = role.`id` AND role.`id` = role_power.`role_id` AND role_power.`powr_id` = power.`id`"
    )
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "role", column = "type"),
            @Result(property = "power", column = "powerName"),
    })
    List<AuthDAO> getAllStaff_RoleAndPower();

    /**
     * 获取某个成员的角色和权限
     * @return
     */
    @Select("SELECT staff.`id`,staff.`name`,role.`type`,power.`powerName`" +
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
    List<AuthDAO> getStaff_RoleAndPower(String staffId);



}

package com.ddu.goushushenpixitong.auth.Service;

import com.ddu.goushushenpixitong.auth.entity.Role;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-01-31 31
 */
public interface RoleService {


    /**
     * 添加角色
     * @param role 角色
     * @return
     */
    Boolean add(Role role);

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @return
     */
    Boolean remove(int roleId);


    /**
     * 修改角色信息
     * @param role 修改的角色信息
     * @return
     */
    Boolean updateRole(Role role);


    /**
     * 分页获取所有角色
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<Role> findAllRole(int currentPage, int pageSize);

    /**
     * 查询某个角色信息
     * @param roleId 角色id
     * @return
     */
    Role findRoleByRoleId(int roleId);

}
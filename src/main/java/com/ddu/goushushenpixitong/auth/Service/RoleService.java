package com.ddu.goushushenpixitong.auth.Service;

import com.ddu.goushushenpixitong.auth.entity.Role;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-01-31 31
 */
public interface RoleService {
    /**
     * 增加记录
     *
     * @param role
     * @return
     */
    Boolean add(Role role);

    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    Boolean remove(String id);

    /**
     * 更新信息
     *
     * @param role
     * @return
     */
    Boolean modify(Role role);

    /**
     * 分页获取所有人员的角色信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<Role> findRoleByPage(int currentPage, int pageSize);

    /**
     * 用工号查其所有的角色
     *
     * @param id 工号id
     * @return
     */
    List<Role> findById(int id);

}
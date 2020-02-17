package com.ddu.goushushenpixitong.auth.Service;

import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Role_Power;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-02-04 04
 */
public interface Role_PowerService {

    /**
     * 为某个角色添加某个权限
     * @param role_power 角色-权限
     * @return
     */
    Boolean add(Role_Power role_power);


    /**
     * 删除某个角色的某个权限
     * @param role_powerId 角色-权限id
     * @return
     */
    Boolean delete(int role_powerId);

    /**
     * 分页获取所有人员的权限信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<AuthDAO> findAllPowersByPage(int currentPage, int pageSize);

    /**
     * 用工号查其所有的权限
     *
     * @param id 工号id
     * @return
     */
    List<AuthDAO> findPowerByStaffId(String id);
}

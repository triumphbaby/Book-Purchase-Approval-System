package com.ddu.goushushenpixitong.auth.Service;

import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Staff_Role;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-02-04 04
 */
public interface Staff_RoleService {

    /**
     * 为某个成员添加某个角色
     * @return
     */
    Boolean add(Staff_Role staff_role);

    /**
     * 删除某个成员的某个角色
     * @param staff_role_id   staff_role表id
     * @return
     */
    Boolean delStaffRole(int  staff_role_id);

    /**
     * 分页获取所有人员的角色信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<AuthDAO> findRoleByPage(int currentPage, int pageSize);

    /**
     * 用工号查其所有的角色
     *
     * @param staffid 工号id
     * @return
     */
    List<AuthDAO> findStaffRoleById(String staffid);

}

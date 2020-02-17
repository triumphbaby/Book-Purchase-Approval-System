package com.ddu.goushushenpixitong.auth.Service.impl;

import com.ddu.goushushenpixitong.auth.Service.Staff_RoleService;
import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Staff_Role;
import com.ddu.goushushenpixitong.auth.mapper.Staff_RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-02-04 04
 */
@Service
public class Staff_RoleServiceImpl implements Staff_RoleService {

    private final static int SUCCESS = 1;

    @Autowired
    private Staff_RoleMapper staff_roleMapper;


    @Override
    public Boolean add(Staff_Role staff_role) {
        return staff_roleMapper.insert(staff_role) == SUCCESS;
    }

    @Override
    public Boolean delStaffRole(int staff_role_id) {
        return staff_roleMapper.deleteByPrimaryKey(staff_role_id) == SUCCESS;
    }

    @Override
    public List<AuthDAO> findRoleByPage(int currentPage, int pageSize) {
        return staff_roleMapper.getAllStaffRole();
    }

    @Override
    public List<AuthDAO> findStaffRoleById(String staffid) {
        return staff_roleMapper.getRolesByStaffId(staffid);
    }
}

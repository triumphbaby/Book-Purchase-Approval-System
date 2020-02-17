package com.ddu.goushushenpixitong.auth.Service.impl;

import com.ddu.goushushenpixitong.auth.Service.RoleService;
import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Role;
import com.ddu.goushushenpixitong.auth.entity.Staff_Role;
import com.ddu.goushushenpixitong.auth.mapper.RoleMapper;
import com.ddu.goushushenpixitong.auth.mapper.Staff_RoleMapper;
import com.ddu.goushushenpixitong.mapper.StaffMapper;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-01-31 31
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final static int SUCCESS = 1;

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Boolean add(Role role) {
        return roleMapper.insert(role) == SUCCESS;
    }

    @Override
    public Boolean remove(int roleId) {
        return roleMapper.deleteByPrimaryKey(roleId) == SUCCESS;
    }

    @Override
    public Boolean updateRole(Role role) {
        return roleMapper.updateByPrimaryKey(role) == SUCCESS;
    }


    @Override
    public List<Role> findAllRole(int currentPage, int pageSize) {
        return roleMapper.selectAll();
    }

    @Override
    public Role findRoleByRoleId(int roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }


}

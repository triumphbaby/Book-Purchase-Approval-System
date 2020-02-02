package com.ddu.goushushenpixitong.auth.Service.impl;

import com.ddu.goushushenpixitong.auth.Service.AuthService;
import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Power;
import com.ddu.goushushenpixitong.auth.entity.Role;
import com.ddu.goushushenpixitong.auth.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-01-15 15
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    Staff_RoleMapper staff_roleMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    Role_PowerMapper role_powerMapper;

    @Autowired
    PowerMapper powerMapper;

    @Autowired
    AuthMapper authMapper;


    @Override
    public List<Integer> getRoleIdByUserId(String userId) {
        return staff_roleMapper.getRoleIdByUserId(userId);
    }

    @Override
    public List<Integer> getPowerIdByRoleId(int rolerId) {
        return role_powerMapper.getPowerByRoleId(rolerId);
    }

    @Override
    public Role getRoleByRoleId(int roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public Power getPowerByPowerId(int powerId) {
        return powerMapper.selectByPrimaryKey(powerId);
    }

    @Override
    public List<AuthDAO> getAllStaff_RoleAndPower() {
        return  authMapper.getAllStaff_RoleAndPower();
    }

    @Override
    public List<AuthDAO> getStaff_RoleAndPower(String staffId) {
        return authMapper.getStaff_RoleAndPower(staffId);

    }

}

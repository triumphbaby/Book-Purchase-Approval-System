package com.ddu.goushushenpixitong.auth.Service.impl;

import com.ddu.goushushenpixitong.auth.Service.Role_PowerService;
import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Role_Power;
import com.ddu.goushushenpixitong.auth.mapper.Role_PowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-02-04 04
 */
@Service
public class Role_PowerServiceImpl implements Role_PowerService {

    private final static int SUCCESS = 1;
    @Autowired
    private Role_PowerMapper role_powerMapper;


    @Override
    public Boolean add(Role_Power role_power) {
        return role_powerMapper.insert(role_power) == SUCCESS;
    }

    @Override
    public Boolean delete(int role_powerId) {
        return role_powerMapper.deleteByPrimaryKey(role_powerId) == SUCCESS;
    }

    @Override
    public List<AuthDAO> findAllPowersByPage(int currentPage, int pageSize) {
        return role_powerMapper.getAllStaffPower();
    }

    @Override
    public List<AuthDAO> findPowerByStaffId(String staffId) {
        return role_powerMapper.getStaffPower(staffId);
    }

}

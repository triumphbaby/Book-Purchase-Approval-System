package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Role;
import com.ddu.goushushenpixitong.mapper.RoleMapper;
import com.ddu.goushushenpixitong.service.RoleService;
import com.ddu.goushushenpixitong.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final static int SUCCESS = 1;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Boolean add(Role role) {
        return roleMapper.insertSelective(role) == SUCCESS;
    }

    @Override
    public Boolean remove(String id) {
        return roleMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Role role) {
        return roleMapper.updateByPrimaryKey(role) == SUCCESS;
    }

    @Override
    public List<Role> findRoleByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Role> allRoles = roleMapper.selectAll();
        int countNums = roleMapper.selectCount(new Role());
        PageBean<Role> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allRoles);
        return pageData.getItems();
    }

    @Override
    public List<Role> findById(String id) {
        return roleMapper.select(new Role(id, null, null));
    }
}

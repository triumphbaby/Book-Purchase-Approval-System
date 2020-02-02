package com.ddu.goushushenpixitong.auth.Service.impl;

import com.ddu.goushushenpixitong.auth.Service.RoleService;
import com.ddu.goushushenpixitong.auth.entity.Role;
import com.ddu.goushushenpixitong.auth.mapper.RoleMapper;
import com.ddu.goushushenpixitong.entity.Staff;
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

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public Boolean add(Role role) {
        return roleMapper.insert(role) == SUCCESS;
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

        //获取所有人员
        List<Staff> staffs = staffMapper.selectAll();
        Integer countNums = staffs.size();
        //查询每个人员的角色
        for (Staff s:staffs) {
        }

        List<Role> allRoles = roleMapper.selectAll();


        PageBean<Role> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allRoles);
        return pageData.getItems();
    }

    @Override
    public List<Role> findById(int id) {
        return roleMapper.select(new Role(id, null, null));
    }
}

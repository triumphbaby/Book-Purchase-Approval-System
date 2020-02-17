package com.ddu.goushushenpixitong.auth.Service;

import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Power;
import com.ddu.goushushenpixitong.auth.entity.Role;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-02-04 04
 */
public interface PowerService {


    /**
     * 添加权限
     * @param power 新权限
     * @return
     */
    Boolean add(Power power);

    /**
     * 删除某个权限
     *
     * @param powerId 权限id
     * @return
     */
    Boolean remove(int powerId);


    /**
     * 修改权限信息
     * @param power 修改的权限
     * @return
     */
    Boolean update(Power power);

    /**
     * 分页获取所有权限
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<Power> findAllPower(int currentPage, int pageSize);

    /**
     * 获取某个权限信息
     * @param powerId 权限id
     * @return
     */
    Power getOne(int powerId);



}

package com.ddu.goushushenpixitong.auth.Service;

import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.entity.Power;
import com.ddu.goushushenpixitong.auth.entity.Role;

import java.util.List;

/**
 * 这个Service仅用于认证时查询角色id，权限id，角色，权限
 * 不进行具体对于角色，权限的操作
 * @auther ChunKitAu
 * @create 2020-01-29 15
 */
public interface AuthService {

    /**
     * 根据用户id获取该用户对应的角色id
     * @param userId 用户id
     * @return 角色id
     */
    List<Integer> getRoleIdByUserId(String userId);

    /**
     * 根据角色id获取改角色对应的权限id
     * @param rolerId 角色id
     * @return 权限id
     */
    List<Integer> getPowerIdByRoleId(int rolerId);

    /**
     * 根据角色id获取角色
     * @param roleId 角色id
     * @return 角色
     */
    Role getRoleByRoleId(int roleId);

    /**
     * 根据权限id获取权限
     * @param powerId 权限id
     * @return 权限
     */
    Power getPowerByPowerId(int powerId);

    /**
     * 获取所有人员的角色和权限
     * @return
     */
    List<AuthDAO> getAllStaff_RoleAndPower();

    /**
     * 获取某个人员的角色和权限
     * @param staffId 人员id
     * @return
     */
    List<AuthDAO> getStaff_RoleAndPower(String staffId);



}

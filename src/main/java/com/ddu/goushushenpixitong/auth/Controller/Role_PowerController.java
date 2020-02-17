package com.ddu.goushushenpixitong.auth.Controller;

import com.ddu.goushushenpixitong.auth.Service.PowerService;
import com.ddu.goushushenpixitong.auth.Service.RoleService;
import com.ddu.goushushenpixitong.auth.Service.Role_PowerService;
import com.ddu.goushushenpixitong.auth.entity.Role_Power;
import com.ddu.goushushenpixitong.auth.entity.Staff_Role;
import com.ddu.goushushenpixitong.auth.mapper.PowerMapper;
import com.ddu.goushushenpixitong.auth.mapper.RoleMapper;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther ChunKitAu
 * @create 2020-02-05 05
 */
@RestController
@RequiresRoles("管理员")
@RequestMapping("/role_power")
public class Role_PowerController {

    @Autowired
    Role_PowerService role_powerService;

    @Autowired
    RoleService roleService;

    @Autowired
    PowerService powerService;
    /**
     * 查询所有人员的权限信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult staffList(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                                  @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(role_powerService.findAllPowersByPage(currentPage, pageSize));
    }

    /**
     * 查询某个工号的所有权限信息
     *
     * @param staffid 工号
     * @return
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult getOne(@RequestParam("staffId") String staffid) {
        return CommonResult.success(role_powerService.findPowerByStaffId(staffid));
    }


    /**
     * 为某个角色添加某个权限
     * @param role_power 人员-角色
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult addStaffRole(Role_Power role_power) {
        int roleId = role_power.getRoleId();
        int powerId = role_power.getPowerId();
        if(roleService.findRoleByRoleId(roleId)==null) return CommonResult.failure("当前角色不存在");
        if(powerService.getOne(powerId) == null) return CommonResult.failure("当前权限不存在");
        return CommonResult.expect(role_powerService.add(role_power));
    }

    /**
     * 删除某个角色的某个权限
     * @param role_power Id
     * @return
     */
    @DeleteMapping
    @RequiresPermissions("root")
    public CommonResult dele(@RequestParam("role_powerId") int role_power){
        return CommonResult.expect(role_powerService.delete(role_power));
    }

}

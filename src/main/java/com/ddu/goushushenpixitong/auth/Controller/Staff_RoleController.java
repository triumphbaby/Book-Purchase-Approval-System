package com.ddu.goushushenpixitong.auth.Controller;

import com.ddu.goushushenpixitong.auth.Service.RoleService;
import com.ddu.goushushenpixitong.auth.Service.Staff_RoleService;
import com.ddu.goushushenpixitong.auth.entity.Staff_Role;
import com.ddu.goushushenpixitong.service.StaffService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther ChunKitAu
 * @create 2020-02-04 04
 */
@RequiresRoles("管理员")
@RestController
@RequestMapping("/staff_role")
public class Staff_RoleController  {

    @Autowired
    Staff_RoleService staff_roleService;

    @Autowired
    RoleService roleService;

    @Autowired
    StaffService staffService;

    /**
     * 查询所有人员的角色信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult staffList(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                                  @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(staff_roleService.findRoleByPage(currentPage, pageSize));
    }

    /**
     * 查询某个工号的所有角色信息
     *
     * @param staffid 工号
     * @return
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult getOne(@RequestParam("staffId") String staffid) {
        return CommonResult.success(staff_roleService.findStaffRoleById(staffid));
    }


    /**
     * 为某个成员添加某个角色
     * @param staff_role 人员-角色
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult addStaffRole(Staff_Role staff_role) {
        Integer roleId = staff_role.getRoleId();
        String staffId = staff_role.getStaffId();
        if(roleService.findRoleByRoleId(roleId) == null) return CommonResult.failure("当前角色不存在");
        if(staffService.findById(staffId) == null) return  CommonResult.failure("当前人员不存在");
        return CommonResult.expect(staff_roleService.add(staff_role));
    }

    /**
     * 删除某个成员的某个角色
     * @param staff_roleId id
     * @return
     */
    @DeleteMapping
    @RequiresPermissions("root")
    public CommonResult dele(@RequestParam("staff_roleId") int staff_roleId){
        return CommonResult.expect(staff_roleService.delStaffRole(staff_roleId));
    }


}

package com.ddu.goushushenpixitong.auth.Controller;

import com.ddu.goushushenpixitong.auth.Service.RoleService;
import com.ddu.goushushenpixitong.auth.entity.Role;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiresRoles("管理员")
@RestController
@RequestMapping("/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有的角色
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                                 @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(roleService.findAllRole(currentPage, pageSize));
    }

    /**
     * 查询某个角色的信息
     * @param roleId 角色id
     * @return
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult getOne(@RequestParam("roleId")int roleId){
        return  CommonResult.success(roleService.findRoleByRoleId(roleId));
    }

    /**
     * 添加角色
     * @param role 新角色
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult add(Role role){
        return  CommonResult.expect(roleService.add(role));
    }


    /**
     * 修改某个角色信息
     * @param role 修改的角色信息
     * @return
     */
    @PutMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public  CommonResult update(Role role){
        return CommonResult.expect(roleService.updateRole(role));
    }


    /**
     * 删除角色
     * @param roleId 角色id
     * @return
     */
    @DeleteMapping
    @RequiresPermissions("root")
    public CommonResult delete(@RequestParam("roleId") int roleId) {
        return CommonResult.expect(roleService.remove(roleId));
    }

}

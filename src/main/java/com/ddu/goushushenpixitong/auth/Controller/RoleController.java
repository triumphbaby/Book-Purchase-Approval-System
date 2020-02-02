package com.ddu.goushushenpixitong.auth.Controller;

import com.ddu.goushushenpixitong.auth.Service.RoleService;
import com.ddu.goushushenpixitong.auth.entity.Role;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiresRoles("管理员")
@RestController
@RequestMapping("/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有人员的角色信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
        public CommonResult list(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return CommonResult.success(roleService.findRoleByPage(currentPage, pageSize));
    }

    /**
     * 查询某个工号的所有角色信息
     *
     * @param id 工号
     * @return
     */
    @GetMapping
    public CommonResult getOne(@RequestParam("id") int id) {
        return CommonResult.success(roleService.findById(id));
    }

    /**
     * 添加角色记录
     *
     * @param role
     * @return
     */
    @PostMapping
    public CommonResult register(Role role) {
        return CommonResult.expect(roleService.add(role));
    }

    /**
     * 更新信息
     *
     * @param role
     * @return
     */
    @PutMapping
    public CommonResult amend(@Valid Role role) {
        if (role.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(roleService.modify(role));
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") String id) {
        return CommonResult.expect(roleService.remove(id));
    }

}

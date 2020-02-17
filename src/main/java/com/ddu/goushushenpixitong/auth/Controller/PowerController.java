package com.ddu.goushushenpixitong.auth.Controller;

import com.ddu.goushushenpixitong.auth.Service.PowerService;
import com.ddu.goushushenpixitong.auth.entity.Power;
import com.ddu.goushushenpixitong.auth.entity.Role;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther ChunKitAu
 * @create 2020-02-01 01
 */
@RequiresRoles("管理员")
@RestController
@RequestMapping("/power")
public class PowerController {

    @Autowired
    PowerService powerService;

    /**
     * 查询所有的权限
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(powerService.findAllPower(currentPage, pageSize));
    }

    /**
     * 查询某个权限的信息
     * @param powerId 角色id
     * @return
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult getOne(@RequestParam("powerId")int powerId){
        return  CommonResult.success(powerService.getOne(powerId));
    }

    /**
     * 添加权限
     * @param power 新权限
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult add(Power power){
        return  CommonResult.expect(powerService.add(power));
    }


    /**
     * 修改某个权限信息
     * @param power 修改的权限信息
     * @return
     */
    @PutMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public  CommonResult update(Power power){
        return CommonResult.expect(powerService.update(power));
    }


    /**
     * 删除权限
     * @param powerId 权限id
     * @return
     */
    @RequiresPermissions("root")
    @DeleteMapping
    public CommonResult delete(@RequestParam("powerId") int powerId) {
        return CommonResult.expect(powerService.remove(powerId));
    }

}

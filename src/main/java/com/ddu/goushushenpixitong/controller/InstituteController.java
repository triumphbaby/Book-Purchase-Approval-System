package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Institute;
import com.ddu.goushushenpixitong.service.InstituteService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiresRoles("管理员")
@RestController
@RequestMapping("/institute")
public class InstituteController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InstituteService instituteService;

    /**
     * 分页查询学院列表
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(instituteService.findInstituteByPage(currentPage, pageSize));
    }

    /**
     * 通过编号查询学院
     *
     * @param id 学院编号
     * @return
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult getOne(@RequestParam("id") String id) {
        return CommonResult.success(instituteService.findById(id));
    }

    /**
     * 注册学院
     *
     * @param institute
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult register(Institute institute) {
        return CommonResult.expect(instituteService.add(institute));
    }

    /**
     * 修改学院信息
     *
     * @param institute
     * @return
     */
    @PutMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult amend(@Valid Institute institute) {
        if (institute.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(instituteService.modify(institute));
    }

    /**
     * 删除学院
     *
     * @param id 学院编号
     * @return
     */
    @RequiresPermissions("root")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") String id) {
        return CommonResult.expect(instituteService.remove(id));
    }

}

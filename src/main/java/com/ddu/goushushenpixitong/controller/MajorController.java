package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Major;
import com.ddu.goushushenpixitong.service.InstituteService;
import com.ddu.goushushenpixitong.service.MajorService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiresRoles("管理员")
@RestController
@RequestMapping("/major")
public class MajorController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MajorService majorService;

    @Autowired
    private InstituteService instituteService;
    /**
     * 分页查询专业记录
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(majorService.findMajorByPage(currentPage, pageSize));
    }

    /**
     * 查询单条专业记录
     *
     * @param id 专业编号
     * @return
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult getOne(@RequestParam("id") String id) {
        return CommonResult.success(majorService.findById(id));
    }

    /**
     * 添加专业
     *
     * @param major
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult register(@Valid Major major) {
        String instituteId = major.getInstituteId();
        if(instituteService.findById(instituteId) == null)return CommonResult.failure("当前学院不存在");
        return CommonResult.expect(majorService.add(major));
    }

    /**
     * 更新记录
     *
     * @param major
     * @return
     */
    @PutMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult amend(@Valid Major major) {
        return CommonResult.expect(majorService.modify(major));
    }

    /**
     * 删除专业
     *
     * @param id 专业编号
     * @return
     */
    @RequiresPermissions("root")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") String id) {
        return CommonResult.expect(majorService.remove(id));
    }

}

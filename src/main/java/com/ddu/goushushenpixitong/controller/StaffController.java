package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Staff;
import com.ddu.goushushenpixitong.service.InstituteService;
import com.ddu.goushushenpixitong.service.MajorService;
import com.ddu.goushushenpixitong.service.StaffService;
import com.ddu.goushushenpixitong.util.CommonResult;
import com.ddu.goushushenpixitong.util.PoiUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiresRoles("管理员")
@RestController
@RequestMapping("/staff")
public class StaffController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StaffService staffService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private InstituteService instituteService;

    /**
     * 查询所有人员信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(staffService.findStaffByPage(currentPage, pageSize));
    }

    /**
     * 提供导入教职工信息表模板
     *
     * @param request
     * @param response
     */
    @GetMapping("/excel")
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public void importTemplate(HttpServletRequest request, HttpServletResponse response) {
        PoiUtil.export(staffService.getTemplate(), "教职工信息表", response);
    }

    /**
     * 查询单条记录
     *
     * @param id 工号
     * @return
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult getOne(@RequestParam("id") String id) {
        return CommonResult.success(staffService.findById(id));
    }

    /**
     * 添加人员
     *
     * @param staff
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult register(Staff staff) {
        if(majorService.findById(staff.getMajorId()) == null) return CommonResult.failure("当前专业不存在");
        if(instituteService.findById(staff.getInstituteId()) == null) return CommonResult.failure("当前学院不存在");
        return CommonResult.expect(staffService.add(staff));
    }

    /**
     * 解析上传的教职工信息表
     *
     * @return
     */
    @PostMapping("/excel")
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult parseExcel(@RequestParam("file") MultipartFile file) {
        return staffService.parseExcel(file);
    }

    /**
     * 更新信息
     *
     * @param staff
     * @return
     */
    @PutMapping
    @RequiresPermissions(logical = Logical.OR,value = {"root"})
    public CommonResult amend(@Valid Staff staff) {
        if (staff.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(staffService.modify(staff));
    }

    /**
     * 删除人员
     *
     * @param id
     * @return
     */
    @RequiresPermissions("root")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") String id) {
        return CommonResult.expect(staffService.remove(id));
    }

}

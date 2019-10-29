package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.DeanOffice;
import com.ddu.goushushenpixitong.service.ApprovalService;
import com.ddu.goushushenpixitong.service.DeanOfficeService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiresRoles(logical = Logical.OR,value = {"管理员", "教研室主任"})
@RestController
@RequestMapping("/deanoffice")
public class DeanOfficeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeanOfficeService deanOfficeService;

    @Autowired
    private ApprovalService approvalService;

    /**
     * 分页获取教务处审核条目
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public CommonResult list(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return CommonResult.success(deanOfficeService.findDeanOfficeByPage(currentPage, pageSize));
    }

    /**
     * 获取单条审核条目记录
     *
     * @param id
     * @return
     */
    @GetMapping
    public CommonResult getOne(@RequestParam("id") Integer id) {
        return CommonResult.success(deanOfficeService.findById(id));
    }

    /**
     * 获取科研室审核结果
     *
     * @param subjectId
     * @return
     */
    @GetMapping("/opinions")
    public CommonResult showOpinion(@RequestParam("subjectId") Integer subjectId) {
        return CommonResult.success(approvalService.findDeanOfficeOpinions(subjectId));
    }

    /**
     * 添加审核条目
     *
     * @param deanOffice
     * @return
     */
    @PostMapping
    public CommonResult register(DeanOffice deanOffice) {
        return CommonResult.expect(deanOfficeService.add(deanOffice));
    }

    /**
     * 添加教务处审核结果
     *
     * @param subjectId  课程用书id
     * @param jsonString 结果json
     * @return
     */
    @PostMapping("/opinions")
    public CommonResult submitOpinion(@RequestParam("subjectId") Integer subjectId, @RequestParam("jsonString") String jsonString) {
        return CommonResult.expect(approvalService.addDeanOfficeOpinions(subjectId, jsonString));
    }

    /**
     * 更新条目信息
     *
     * @param deanOffice
     * @return
     */
    @PutMapping
    public CommonResult amend(@Valid DeanOffice deanOffice) {
        if (deanOffice.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(deanOfficeService.modify(deanOffice));
    }

    /**
     * 删除条目
     *
     * @param id
     * @return
     */
    @RequiresRoles("管理员")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") Integer id) {
        return CommonResult.expect(deanOfficeService.remove(id));
    }
}

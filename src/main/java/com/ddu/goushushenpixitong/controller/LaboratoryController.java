package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Laboratory;
import com.ddu.goushushenpixitong.service.ApprovalService;
import com.ddu.goushushenpixitong.service.LaboratoryService;
import com.ddu.goushushenpixitong.service.SubjectService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiresRoles(logical = Logical.OR, value = {"管理员", "教研室主任"})
@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LaboratoryService laboratoryService;

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private SubjectService subjectService;
    /**
     * 分页获取教研室审核条目
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions(logical = Logical.OR,value = {"laboratory_query","root"})
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(laboratoryService.findLaboratoryByPage(currentPage, pageSize));
    }

    /**
     * 获取单条审核条目记录
     *
     * @param id
     * @return
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.OR,value = {"laboratory_query","root"})
    public CommonResult getOne(@RequestParam("id") Integer id) {
        return CommonResult.success(laboratoryService.findById(id));
    }

    /**
     * 获取科研室审核结果
     *
     * @param subjectId
     * @return
     */
    @GetMapping("/opinions")
    @RequiresPermissions(logical = Logical.OR,value = {"approval_query","root"})
    public CommonResult showOpinion(@RequestParam("subjectId") Integer subjectId) {
        return CommonResult.success(approvalService.findLaboratoryOpinions(subjectId));
    }

    /**
     * 添加审核条目
     *
     * @param laboratory
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.OR,value = {"laboratory_add","root"})
    public CommonResult register(Laboratory laboratory) {
        return CommonResult.expect(laboratoryService.add(laboratory));
    }

    /**
     * 添加教研室审核结果
     *
     * @param subjectId  课程用书id
     * @param jsonString 结果json
     * @return
     */
    @PostMapping("/opinions")
    @RequiresPermissions(logical = Logical.OR,value = {"approval_add","root"})
    public CommonResult submitOpinion(@RequestParam("subjectId") Integer subjectId, @RequestBody String jsonString) {
        if(subjectService.findById(subjectId) == null) return CommonResult.failure("当前课程用书不存在");
        return approvalService.addLaboratoryOpinions(subjectId, jsonString);
    }

    /**
     * 更新条目信息
     *
     * @param laboratory
     * @return
     */
    @PutMapping
    @RequiresPermissions(logical = Logical.OR,value = {"laboratory_update","root"})
    public CommonResult amend(@Valid Laboratory laboratory) {
        if (laboratory.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(laboratoryService.modify(laboratory));
    }

    /**
     * 删除条目
     *
     * @param id
     * @return
     */
    @RequiresPermissions("root")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") Integer id) {
        return CommonResult.expect(laboratoryService.remove(id));
    }

}

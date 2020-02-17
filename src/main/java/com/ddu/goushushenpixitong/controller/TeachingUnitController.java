package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.TeachingUnit;
import com.ddu.goushushenpixitong.service.ApprovalService;
import com.ddu.goushushenpixitong.service.SubjectService;
import com.ddu.goushushenpixitong.service.TeachingUnitService;
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
@RequestMapping("/teachingunit")
public class TeachingUnitController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TeachingUnitService teachingUnitService;

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private SubjectService subjectService;

    /**
     * 分页获取开课教学单位审核条目
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions(logical = Logical.OR,value = {"teachingUnit_query","root"})
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(teachingUnitService.findTeachingUnitByPage(currentPage, pageSize));
    }

    /**
     * 获取单条审核条目记录
     *
     * @param id
     * @return
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.OR,value = {"teachingUnit_query","root"})
    public CommonResult getOne(@RequestParam("id") Integer id) {
        return CommonResult.success(teachingUnitService.findById(id));
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
        return CommonResult.success(approvalService.findTeachingUnitOpinions(subjectId));
    }

    /**
     * 添加审核条目
     *
     * @param teachingUnit
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.OR,value = {"teachingUnit_add","root"})
    public CommonResult register(TeachingUnit teachingUnit) {
        return CommonResult.expect(teachingUnitService.add(teachingUnit));
    }

    /**
     * 添加开课教学单位审核结果
     *
     * @param subjectId  课程用书id
     * @param jsonString 结果json
     * @return
     */
    @PostMapping("/opinions")
    @RequiresPermissions(logical = Logical.OR,value = {"approval_add","root"})
    public CommonResult submitOpinion(@RequestParam("subjectId") Integer subjectId, @RequestBody String jsonString) {
        if(subjectService.findById(subjectId) == null) return CommonResult.failure("当前课程用书不存在");
        return approvalService.addTeachingUnitOpinions(subjectId, jsonString);
    }

    /**
     * 更新条目信息
     *
     * @param teachingUnit
     * @return
     */
    @PutMapping
    @RequiresPermissions(logical = Logical.OR,value = {"teachingUnit_update","root"})
    public CommonResult amend(@Valid TeachingUnit teachingUnit) {
        if (teachingUnit.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(teachingUnitService.modify(teachingUnit));
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
        return CommonResult.expect(teachingUnitService.remove(id));
    }
}

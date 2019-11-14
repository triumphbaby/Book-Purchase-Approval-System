package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Subject;
import com.ddu.goushushenpixitong.service.SubjectService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询所有课程用书信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人", "教研室主任"})
    @GetMapping("/list")
    public CommonResult list(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return CommonResult.success(subjectService.findSubjectsByPage(currentPage, pageSize));
    }

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人", "教研室主任"})
    @GetMapping
    public CommonResult getOne(@RequestParam("id") Integer id) {
        return CommonResult.success(subjectService.findById(id));
    }

    /**
     * 添加
     *
     * @param subject
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人"})
    @PostMapping
    public CommonResult register(Subject subject) {
        return CommonResult.expect(subjectService.add(subject));
    }

    /**
     * 更新
     *
     * @param subject
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人"})
    @PutMapping
    public CommonResult amend(@Valid Subject subject) {
        if (subject.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(subjectService.modify(subject));
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequiresRoles("管理员")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") Integer id) {
        return CommonResult.expect(subjectService.remove(id));
    }
}

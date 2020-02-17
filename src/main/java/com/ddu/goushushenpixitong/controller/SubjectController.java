package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Subject;
import com.ddu.goushushenpixitong.service.*;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/subject")
@RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人", "教研室主任"})
public class SubjectController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TermService termService;

    @Autowired
    private BookService bookService;

    @Autowired
    private InstituteService instituteService;
    /**
     * 查询所有课程用书信息
     * 根据当前人员的所属的学院查询所属学院的用户
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"subject_query","root"})
    @GetMapping("/list")
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(subjectService.findSubjectsByPage(currentPage, pageSize));
    }

    /**
     * 查询所有课程用书信息
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"subject_query","root"})
    @GetMapping("/allList")
    public CommonResult AllList(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(subjectService.findAll(currentPage, pageSize));
    }


    /**
     * 模糊搜索课程用书
     * @param bookName 书名
     * @param termName 学期名
     * @param courseName 课程名
     * @return 书本记录
     */
    @RequiresPermissions(logical = Logical.OR,value = {"subject_query","root"})
    @GetMapping("/fuzzySearch")
    public CommonResult fuzzySearch(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                                    @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize,
                                    @RequestParam(name ="bookName",required = false) String bookName,
                                    @RequestParam(name = "termName",required = false)String termName,
                                    @RequestParam(name = "courseName",required = false)String courseName){
        return CommonResult.success(subjectService.fuzzySearch(currentPage,pageSize,bookName,termName,courseName));
    }

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"subject_query","root"})
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
    @RequiresPermissions(logical = Logical.OR,value = {"subject_add","root"})
    @PostMapping
    public CommonResult register(Subject subject) {
        if(courseService.findById(subject.getCourseId()) == null) return CommonResult.failure("当前课程不存在");
        if(termService.findById(subject.getTermId()) ==null) return   CommonResult.failure("当前学期不存在");
        if(bookService.findById(subject.getBookId()) ==null) return   CommonResult.failure("当前图书不存在");
        if(instituteService.findById(subject.getInstituteId()) ==null) return   CommonResult.failure("当前学院不存在");
        return CommonResult.expect(subjectService.add(subject));
    }

    /**
     * 更新
     *
     * @param subject
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"subject_update","root"})
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
    @RequiresPermissions("root")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") Integer id) {
        return CommonResult.expect(subjectService.remove(id));
    }
}

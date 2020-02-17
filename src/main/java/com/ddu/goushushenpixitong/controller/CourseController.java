package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Course;
import com.ddu.goushushenpixitong.service.CourseService;
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
@RequestMapping("/course")
@RequiresRoles(logical = Logical.OR, value = {"管理员", "教研室主任","课程负责人"})
public class CourseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseService courseService;

    /**
     * 查询所有课程信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"course_query","root"})
    @GetMapping("/list")
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(courseService.findCoursesByPage(currentPage, pageSize));
    }

    /**
     * 查询单条记录
     *根据id和学期id查询
     * @param id     课程编号
     * @param termId 学期编号
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"course_query","root"})
    @GetMapping("/idAndTerm")
    public CommonResult getOneByTermIdAndId(@RequestParam("id") String id, @RequestParam("termId") Integer termId) {
        return CommonResult.success(courseService.findByIdAndTermId(id, termId));
    }


    /**
     * 查询单条记录
     *
     * @param id     课程编号
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"course_query","root"})
    @GetMapping
    public CommonResult findById(@RequestParam("id") String id) {
        return CommonResult.success(courseService.findById(id));
    }

    /**
     * 添加
     *
     * @param course
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"course_add","root"})
    @PostMapping
    public CommonResult register(Course course) {
        return CommonResult.expect(courseService.add(course));
    }

    /**
     * 更新
     *
     * @param course
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"course_update","root"})
    @PutMapping
    public CommonResult amend(@Valid Course course) {
        if (course.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(courseService.modify(course));
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequiresPermissions("root")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") String id) {
        return CommonResult.expect(courseService.remove(id));
    }
}

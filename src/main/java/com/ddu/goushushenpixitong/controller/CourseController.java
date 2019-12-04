package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Course;
import com.ddu.goushushenpixitong.service.CourseService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/course")
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
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "教研室主任","课程负责人"})
    @GetMapping("/list")
    public CommonResult list(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return CommonResult.success(courseService.findCoursesByPage(currentPage, pageSize));
    }

    /**
     * 查询单条记录
     *
     * @param id     课程编号
     * @param termId 学期编号
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员",  "教研室主任","课程负责人"})
    @GetMapping
    public CommonResult getOne(@RequestParam("id") String id, @RequestParam("termId") Integer termId) {
        return CommonResult.success(courseService.findById(id, termId));
    }

    /**
     * 添加
     *
     * @param course
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员","课程负责人"})
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
    @RequiresRoles(logical = Logical.OR, value = {"管理员","课程负责人"})
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
    @RequiresRoles("管理员")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") String id) {
        return CommonResult.expect(courseService.remove(id));
    }
}

package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Major;
import com.ddu.goushushenpixitong.service.MajorService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiresRoles("管理员")
@RestController
@RequestMapping("/major")
public class MajorController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MajorService majorService;

    /**
     * 分页查询专业记录
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
    public CommonResult list(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return CommonResult.success(majorService.findMajorByPage(currentPage, pageSize));
    }

    /**
     * 查询单条专业记录
     *
     * @param id 专业编号
     * @return
     */
    @GetMapping
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
    public CommonResult register(@Valid Major major) {
        return CommonResult.expect(majorService.add(major));
    }

    /**
     * 更新记录
     *
     * @param major
     * @return
     */
    @PutMapping
    public CommonResult amend(@Valid Major major) {
        return CommonResult.expect(majorService.modify(major));
    }

    /**
     * 删除专业
     *
     * @param id 专业编号
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") String id) {
        return CommonResult.expect(majorService.remove(id));
    }

}

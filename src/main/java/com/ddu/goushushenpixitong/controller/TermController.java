package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Term;
import com.ddu.goushushenpixitong.service.TermService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RequiresRoles("管理员")
@RestController
@RequestMapping("/term")
public class TermController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TermService termService;

    /**
     * 查询所有学期信息
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @GetMapping("/list")
    public CommonResult list(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return CommonResult.success(termService.findTermByPage(currentPage, pageSize));
    }

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    @GetMapping
    public CommonResult getOne(@RequestParam("id") Integer id) {
        return CommonResult.success(termService.findById(id));
    }

    /**
     * 添加学期记录
     *
     * @param term
     * @return
     */
    @PostMapping
    public CommonResult register(Term term) {
        return CommonResult.expect(termService.add(term));
    }

    /**
     * 更新
     *
     * @param term
     * @return
     */
    @PutMapping
    public CommonResult amend(@Valid Term term) {
        if (term.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(termService.modify(term));
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") Integer id) {
        return CommonResult.expect(termService.remove(id));
    }

}

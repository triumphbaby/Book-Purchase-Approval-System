package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Level;
import com.ddu.goushushenpixitong.service.LevelService;
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
@RequestMapping("/level")
@RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人", "教研室主任"})
public class LevelController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LevelService levelService;

    /**
     * 分页查询等级记录
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"level_query","root"})
    @GetMapping("/list")
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(levelService.findLevelByPage(currentPage, pageSize));
    }

    /**
     * 通过id获取单条记录
     *
     * @param id
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"level_query","root"})
    @GetMapping
    public CommonResult getOne(@RequestParam("id") Integer id) {
        return CommonResult.success(levelService.findById(id));
    }

    /**
     * 添加
     *
     * @param level
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"level_add","root"})
    @PostMapping
    public CommonResult register(Level level) {
        return CommonResult.expect(levelService.add(level));
    }

    /**
     * 修改
     *
     * @param level
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"level_update","root"})
    @PutMapping
    public CommonResult amend(@Valid Level level) {
        if (level.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(levelService.modify(level));
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
        return CommonResult.expect(levelService.remove(id));
    }

}

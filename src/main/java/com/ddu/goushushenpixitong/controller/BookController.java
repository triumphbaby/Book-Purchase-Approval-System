package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Book;
import com.ddu.goushushenpixitong.service.BookService;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    /**
     * 查询所有书本记录
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人", "教研室主任"})
    @GetMapping("/list")
    public CommonResult list(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return CommonResult.success(bookService.findBooksByPage(currentPage, pageSize));
    }

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人", "教研室主任"})
    @GetMapping
    public CommonResult getOne(@RequestParam("id") String id) {
        return CommonResult.success(bookService.findById(id));
    }

    /**
     * 模糊查询获取书本
     * @param like  模糊查询条件
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人", "教研室主任"})
    @GetMapping("/like")
    public CommonResult getByLike(@RequestParam("Like") String like) {
        return CommonResult.success(bookService.findBookByLike(like));
    }

    /**
     * 添加书本记录
     *
     * @param book
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人"})
    @PostMapping
    public CommonResult register(Book book) {
        return CommonResult.expect(bookService.add(book));
    }

    /**
     * 更新
     *
     * @param book
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人"})
    @PutMapping
    public CommonResult amend(@Valid Book book) {
        if (book.getId() == null) {
            return CommonResult.failure("id不能为空");
        }
        return CommonResult.expect(bookService.modify(book));
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
        return CommonResult.expect(bookService.remove(id));
    }
}

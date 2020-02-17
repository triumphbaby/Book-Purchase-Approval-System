package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.entity.Book;
import com.ddu.goushushenpixitong.service.BookService;
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
@RequestMapping("/book")
@RequiresRoles(logical = Logical.OR, value = {"管理员", "课程负责人", "教研室主任"})
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

    @RequiresPermissions(logical = Logical.OR,value = {"book_query","root"})
    @GetMapping("/list")
    public CommonResult list(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                             @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize) {
        return CommonResult.success(bookService.findBooksByPage(currentPage, pageSize));
    }

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"book_query","root"})
    @GetMapping
    public CommonResult getOne(@RequestParam("id") String id) {
        return CommonResult.success(bookService.findById(id));
    }

    /**
     * 根据书本名模糊查询获取书本
     * @param like  模糊书本名
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"book_query","root"})
    @GetMapping("/like")
        public CommonResult getByLike(@RequestParam("bookName") String like) {
        return CommonResult.success(bookService.findBookByLike(like));
    }

    /**
     * 添加书本记录
     *
     * @param book
     * @return
     */
    @RequiresPermissions(logical = Logical.OR,value = {"book_add","root"})
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
    @RequiresPermissions(logical = Logical.OR,value = {"book_update","root"})
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
    @RequiresPermissions("root")
    @DeleteMapping
    public CommonResult delete(@RequestParam("id") String id) {
        return CommonResult.expect(bookService.remove(id));
    }
}

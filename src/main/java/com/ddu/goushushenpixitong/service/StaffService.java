package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Staff;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StaffService {
    /**
     * 添加人员
     *
     * @param staff
     * @return
     */
    Boolean add(Staff staff);

    /**
     * 删除人员
     *
     * @param id 工号
     * @return
     */
    Boolean remove(String id);

    /**
     * 更新信息
     *
     * @param staff
     * @return
     */
    Boolean modify(Staff staff);

    /**
     * 获取人员列表
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示的总记录数
     * @return
     */
    List<Staff> findStaffByPage(int currentPage, int pageSize);

    /**
     * 用id查记录
     *
     * @param id 工号
     * @return
     */
    Staff findById(String id);

    /**
     * 获取教职工信息表模板
     *
     * @return
     */
    HSSFWorkbook getTemplate();

    /**
     * 解析教职工信息表
     *
     * @param file
     * @return
     */
    Boolean parseExcel(MultipartFile file);

    /**
     * 根据教师姓名获取id
     *
     * @param name
     * @return
     */
    String findIdByname(String name);

}

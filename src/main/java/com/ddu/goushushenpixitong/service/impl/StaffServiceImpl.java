package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Staff;
import com.ddu.goushushenpixitong.enums.insituteEnum;
import com.ddu.goushushenpixitong.enums.majorEnum;
import com.ddu.goushushenpixitong.mapper.StaffMapper;
import com.ddu.goushushenpixitong.service.StaffService;
import com.ddu.goushushenpixitong.util.CommonResult;
import com.ddu.goushushenpixitong.util.PageBean;
import com.ddu.goushushenpixitong.util.PoiUtil;
import com.github.pagehelper.PageHelper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class StaffServiceImpl implements StaffService {

    private final static int SUCCESS = 1;

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public Boolean add(Staff staff) {
        return staffMapper.insertSelective(staff) == SUCCESS;
    }

    @Override
    public Boolean remove(String id) {
        return staffMapper.deleteByPrimaryKey(id) == SUCCESS;
    }

    @Override
    public Boolean modify(Staff staff) {
        return staffMapper.updateByPrimaryKey(staff) == SUCCESS;
    }

    @Override
    public List<Staff> findStaffByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Staff> allStaffs = staffMapper.selectAll();
        int countNums = staffMapper.selectCount(new Staff());
        PageBean<Staff> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allStaffs);
        return pageData.getItems();
    }

    @Override
    public Staff findById(String id) {
        return staffMapper.selectByPrimaryKey(id);
    }

    @Override
    public HSSFWorkbook getTemplate() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Sheet1");
        HSSFRow row;
        HSSFCell cell;

        for (int i = 0; i < 4; i++) {
            sheet.setColumnWidth(i, 3766);
        }

        /**
         * 标题
         */
        row = sheet.createRow(0);
        cell = row.createCell(0);

        row.setHeightInPoints(30);
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 16, true)));

        cell.setCellValue("教职工信息表");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        /**
         * 基本信息
         */
        row = sheet.createRow(1);

        cell = row.createCell(0);
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 12, false)));
        cell.setCellValue("工号");

        cell = row.createCell(1);
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 12, false)));
        cell.setCellValue("姓名");

        cell = row.createCell(2);
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 12, false)));
        cell.setCellValue("所属专业");

        cell = row.createCell(3);
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 12, false)));
        cell.setCellValue("所属学院");

        /**
         * 内容部分
         */
        row = sheet.createRow(2);
        row.createCell(0).setCellValue(210030204);
        row.getCell(0).setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));

        row.createCell(1).setCellValue("张文远");
        row.getCell(1).setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));

        row.createCell(2).setCellValue("人工智能");
        row.getCell(2).setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));

        row.createCell(3).setCellValue("计算机学院");
        row.getCell(3).setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));


        /**
         * 生成提示信息
         */
        String[] marjorList = {"人工智能","信息安全技术","通信技术"};
        sheet = PoiUtil.setHSSFValidation(sheet,marjorList,2,100,2,2);

        String[] institutelist = { "航空学院", "计算机学院", "商学院", "信息学院", "艺术学院" };
        sheet = PoiUtil.setHSSFValidation(sheet,institutelist,2,100,3,3);


        return wb;
    }

    @Override
    public CommonResult parseExcel(MultipartFile file) {
        if (file.isEmpty()) {
            return CommonResult.failure("解析失败！");
        }
        try {
            String fileName = file.getOriginalFilename();
            InputStream in = file.getInputStream();
            Workbook wb = PoiUtil.getWorkbook(in, fileName);
            Sheet sheet = wb.getSheetAt(0);

            //解析出的人员
            List<Staff> staffs = new ArrayList<>();
            /**
             * 内容获取
             * 若解析的专业，学院不存在直接返回错误 不进行添加操作
             */
            for (int i = 2; sheet.getRow(i) != null; i++) {
                Row row = sheet.getRow(i);
                String id = PoiUtil.double2Int(row.getCell(0).getNumericCellValue()) + "";
                Staff s = staffMapper.selectByPrimaryKey(id);
                if(s!=null)
                    return CommonResult.failure("第"+ (i+1) +"行的工号\""+id+"\"已存在");

                String name = row.getCell(1).getStringCellValue();
                String s1 = staffMapper.selectIdByName(name);
                if(s1 != null)
                    return CommonResult.failure("第"+ (i+1) +"行的员工姓名\""+name+"\"已存在");

                String majorStr = row.getCell(2).getStringCellValue();
                String majorId = majorEnum.majorTypeOf(majorStr);
                if(majorId==null)
                    return CommonResult.failure("第"+ (i+1) +"行的专业\""+majorStr+"\"不存在");

                String instituteStr = row.getCell(3).getStringCellValue();
                String insituteId = insituteEnum.insituteTypeOf(instituteStr);
                if(insituteId==null)
                    return CommonResult.failure("第"+ (i+1) +"行的学院\""+instituteStr+"\"不存在");

                Staff staff = new Staff(id, name, majorId, insituteId, null, null, null);
                staffs.add(staff);
            }

            //添加员工
            if(staffs.size()>0){
                for (Staff staff: staffs){
                    staffMapper.insertSelective(staff);
                }
            }
            return CommonResult.success();

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return CommonResult.failure("解析失败！");
    }

    @Override
    public String findIdByname(String name) {
        return staffMapper.selectIdByName(name);
    }
}

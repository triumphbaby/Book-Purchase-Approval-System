package com.ddu.goushushenpixitong.service.impl;

import com.ddu.goushushenpixitong.entity.Staff;
import com.ddu.goushushenpixitong.mapper.StaffMapper;
import com.ddu.goushushenpixitong.service.StaffService;
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

        row.createCell(2).setCellValue(0);
        row.getCell(2).setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));

        row.createCell(3).setCellValue(0);
        row.getCell(3).setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));

        return wb;
    }

    @Override
    public Boolean parseExcel(MultipartFile file) {
        if (file.isEmpty()) {
            return false;
        }
        try {
            String fileName = file.getOriginalFilename();
            InputStream in = file.getInputStream();
            Workbook wb = PoiUtil.getWorkbook(in,fileName);

            Sheet sheet = wb.getSheetAt(0);
            /**
             * 内容获取
             */
            for (int i = 2; sheet.getRow(i) != null; i++) {
                Row row = sheet.getRow(i);

                String id = PoiUtil.double2Int(row.getCell(0).getNumericCellValue()) + "";
                String name = row.getCell(1).getStringCellValue();
                String majorId = PoiUtil.double2Int(row.getCell(2).getNumericCellValue()) + "";
                String instituteId = PoiUtil.double2Int(row.getCell(3).getNumericCellValue()) + "";
                Staff staff = new Staff(id, name, majorId, instituteId, null, null, null);
                staffMapper.insertSelective(staff);
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public String findIdByname(String name) {
        return staffMapper.selectIdByName(name);
    }
}

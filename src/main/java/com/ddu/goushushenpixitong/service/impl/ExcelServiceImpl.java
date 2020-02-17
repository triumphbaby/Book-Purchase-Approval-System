package com.ddu.goushushenpixitong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ddu.goushushenpixitong.entity.Staff;
import com.ddu.goushushenpixitong.dto.BookPurchasingSchedule;
import com.ddu.goushushenpixitong.entity.*;
import com.ddu.goushushenpixitong.service.*;
import com.ddu.goushushenpixitong.util.ApprovalFormUtil;
import com.ddu.goushushenpixitong.util.CommonResult;
import com.ddu.goushushenpixitong.util.FastjsonUtil;
import com.ddu.goushushenpixitong.util.PoiUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TermService termService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private BookService bookService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private InstituteService instituteService;
    @Autowired
    private LevelService levelService;
    @Autowired
    private ApprovalService approvalService;
    @Autowired
    private LaboratoryService laboratoryService;
    @Autowired
    private DeanOfficeService deanOfficeService;
    @Autowired
    private TeachingUnitService teachingUnitService;

    @Override
    public HSSFWorkbook getBookPurchasingScheduleTemplate() {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet;
        HSSFRow row;
        HSSFCell cell;

        sheet = wb.createSheet("必修");
        for (int i = 0; i < 15; i++) {
            sheet.setColumnWidth(i, 3766);
        }

        /**
         * 标题
         */
        row = sheet.createRow(0);
        cell = row.createCell(0);

        row.setHeightInPoints((short) 30);
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 16, true)));

        cell.setCellValue("北京理工大学珠海学院2018-2019学年第二学期教材征订计划表");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 13));

        /**
         * 基本信息
         */
        row = sheet.createRow(1);

        cell = row.createCell(0);
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 12, false)));
        cell.setCellValue("开课单位：计算机学院");
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 2));

        cell = row.createCell(3);
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 12, false)));
        cell.setCellValue("课程性质：必修课");
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 3, 4));

        cell = row.createCell(8);
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 12, false)));
        cell.setCellValue("报送时间：");

        /**
         * 表格首部
         */
        row = sheet.createRow(2);

        String[] list = BookPurchasingSchedule.getBookPurchasingScheduleInfo();
        for (int i = 0; i < 14; i++) {
            row.createCell(i).setCellValue(list[i]);

            row.getCell(i).setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, true),
                    PoiUtil.setFontStyle(wb, "宋体", (short) 11, true)));

        }

        /**
         * 表格内容
         */
        for (int i = 0; i < 23; i++) {
            row = sheet.createRow(i + 3);

//            fontStyle = wb.createFont();
//            fontStyle.setFontName("宋体");
//            fontStyle.setFontHeightInPoints((short) 10);
//            cellStyle.setFont(fontStyle);
//            row.setRowStyle(cellStyle);

            row.createCell(0).setCellValue(i + 1);
            row.getCell(0).setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                    PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));
        }

        /**
         * 注意部分
         */
        row = sheet.createRow(26);
        cell = row.createCell(0);
        cell.setCellValue("注意：1.请按课程性质，将“必修课”、“选修课”、“实践课”分表进行填写；");
        sheet.addMergedRegion(new CellRangeAddress(26, 26, 0, 12));
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.LEFT, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));

        row = sheet.createRow(27);
        cell = row.createCell(0);
        cell.setCellValue("      2、表中除选修课教材中的“学生数量”项不需填写外，其它均为必填项，请勿漏填。");
        sheet.addMergedRegion(new CellRangeAddress(27, 27, 0, 12));
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.LEFT, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));

        row = sheet.createRow(28);
        cell = row.createCell(0);
        cell.setCellValue("      3、此表一式二份，由开课单位、教务处各执一份备存。");
        sheet.addMergedRegion(new CellRangeAddress(28, 28, 0, 12));
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.LEFT, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 10, false)));

        /**
         * 签名部分
         */
        row = sheet.createRow(29);
        cell = row.createCell(0);
        cell.setCellValue("教研室审核签名：");
        sheet.addMergedRegion(new CellRangeAddress(29, 29, 0, 3));
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 12, true)));

        cell = row.createCell(5);
        cell.setCellValue("开课单位审核签名：");
        sheet.addMergedRegion(new CellRangeAddress(29, 29, 5, 10));
        cell.setCellStyle(PoiUtil.getHSSFCellStyle(PoiUtil.setHSSFCellStyle(wb, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.CENTER, false),
                PoiUtil.setFontStyle(wb, "宋体", (short) 12, true)));

        /**
         * 画格子
         */
        PropertyTemplate pt = new PropertyTemplate();
        pt.drawBorders(new CellRangeAddress(2, 25, 0, 13), BorderStyle.THIN, BorderExtent.ALL);
        pt.drawBorders(new CellRangeAddress(26, 28, 0, 12), BorderStyle.THIN, BorderExtent.OUTSIDE);
        pt.applyBorders(sheet);

        return wb;
    }

    @Override
    public Map<String, String> prepareApprovalFormData(Integer subjectId) {

        Subject subject = subjectService.findById(subjectId);
        Term term = termService.findById(subject.getTermId());
        Course course = courseService.findById(subject.getCourseId());
        Book book = bookService.findById(subject.getBookId());
        Staff principal = staffService.findById(course.getPrincipalId());
        Institute institute = instituteService.findById(principal.getInstituteId());
        Level level = levelService.findById(book.getLevelId());
        Approval approval = approvalService.findById(subjectId);

        Map<String, String> dataMap = ApprovalFormUtil.prepareDataQuick(subject, term, course, book, institute, level);
        JSONObject[] options; //存放审核结果条目（json对象）

        //Laboratory
        options = FastjsonUtil.jsonStr2Array(approval.getOptionLab());
        for (JSONObject jo : options) {
            Integer id = jo.getInteger("id");
            Laboratory laboratory = laboratoryService.findById(id);
            jo.put("content", laboratory.getContent());
        }
        ApprovalFormUtil.setLaboratoryOpinions(dataMap, options);

        //TeachingUnit
        options = FastjsonUtil.jsonStr2Array(approval.getOptionUnit());
        for (JSONObject jo : options) {
            Integer id = jo.getInteger("id");
            TeachingUnit teachingUnit = teachingUnitService.findById(id);
            jo.put("content", teachingUnit.getContent());
        }
        ApprovalFormUtil.setTeachingUnitOpinions(dataMap, options);

        //DeanOffice
        options = FastjsonUtil.jsonStr2Array(approval.getOptionDean());
        for (JSONObject jo : options) {
            Integer id = jo.getInteger("id");
            DeanOffice deanOffice = deanOfficeService.findById(id);
            jo.put("content", deanOffice.getContent());
        }
            ApprovalFormUtil.setDeanOfficeOpinions(dataMap, options);

        ApprovalFormUtil.setSignatureDateOfTeacher(dataMap, "年   月   日");
        ApprovalFormUtil.setSignatureDateOfLab(dataMap, "年   月   日");
        ApprovalFormUtil.setSignatureDateOfUnit(dataMap, "年   月   日");
        ApprovalFormUtil.setSignatureDateOfDean(dataMap, "年   月   日");

        return dataMap;
    }

    @Override
    public CommonResult uploadBookPurchasingSchedule(MultipartFile file) {

        String fileName = file.getOriginalFilename();

        Workbook wb;
        Sheet sheet;
        Row row;
        String content;

        try {
            wb = PoiUtil.getWorkbooks(file,fileName);

            sheet = wb.getSheetAt(0);
            /**
             * 获取标题
             */
            row = sheet.getRow(0);
            content = row.getCell(0).getStringCellValue();
            String year = content.substring(content.indexOf("-") - 4, content.indexOf("-") + 11);
            Integer termid = termService.findIdByName(year);

            if(termid == null) return CommonResult.failure("学期填写不正确");

            /**
             * 基本信息
             */
            //开课单位
            String[] temp;
            row = sheet.getRow(1);
            content = row.getCell(0).getStringCellValue();
            temp = content.split("：");
            if (temp.length > 1) {
                System.out.println(temp[1].toString());
            }
            //课程性质
            content = row.getCell(3).getStringCellValue();
            temp = content.split("：");
            if (temp.length > 1) {
                System.out.println(temp[1].toString());
            }

            //报送时间
            content = row.getCell(8).getStringCellValue();
            temp = content.split("：");
            if (temp.length > 1) {
                System.out.println(temp[1].toString());
            }

            List<Course> cources = new ArrayList<>();

            //循环每一行解析成  BookPurchasingSchedule  对象  然后输出
            for (int i = 3; i < sheet.getLastRowNum() - 3; i++) {
                row = sheet.getRow(i);
                Integer id = PoiUtil.double2Int(row.getCell(0).getNumericCellValue());//序号
                String CourseName = row.getCell(1).getStringCellValue().replace(" ", "").replace("\n", "");//课程名称
                String teacherName = row.getCell(11).getStringCellValue();//选用人

                if(teacherName == null || CourseName ==null || teacherName==""){
                    continue;
                }
                String staffId = staffService.findIdByname(teacherName);
                //验证是否这个老师是否存在  不存在返回错误信息
                if(staffId == null) {
                    return CommonResult.failure("第"+(i+1)+"行错误,不存在"+teacherName+",请检查 ");
                }

                 String usable_range =  row.getCell(8).getStringCellValue().replace(" ", ",").replace("\n", ","); //使用年级、专业及方向
                 Integer student_num =  PoiUtil.double2Int(row.getCell(9).getNumericCellValue()); //学生数量
                 Integer teacher_num =  PoiUtil.double2Int(row.getCell(10).getNumericCellValue()); //教师领用量

                Course course = new Course(UUID.randomUUID().toString().substring(0,8), termid, CourseName, null, null, usable_range, student_num, teacher_num, staffId, null);
                cources.add(course);

            }

            if(!cources.isEmpty()){
                for (Course c: cources) {
                    courseService.add(c);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    return CommonResult.success();
    }


}

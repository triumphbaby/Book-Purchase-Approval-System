package com.ddu.goushushenpixitong.util;

import com.ddu.goushushenpixitong.dto.BookPurchasingSchedule;
import com.ddu.goushushenpixitong.entity.Staff;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class PoiTest extends BaseTest {

    /**
     * 处理教职工信息表
     */
    @Test
    public void test04() {
        String fileName = "E:\\教职工信息表.xls";

        Workbook wb;
        Sheet sheet;
        Row row;

        try {
            wb = PoiUtil.getWorkbook(fileName);

            sheet = wb.getSheetAt(0);
            /**
             * 内容获取
             */
            row = sheet.getRow(2);
            for (int i = 2; sheet.getRow(i) != null; i++) {
                row = sheet.getRow(i);
                try {
                    String id = PoiUtil.double2Int(row.getCell(0).getNumericCellValue()) + "";
                    String name = row.getCell(1).getStringCellValue();
                    String majorId = PoiUtil.double2Int(row.getCell(2).getNumericCellValue()) + "";
                    String instituteId = PoiUtil.double2Int(row.getCell(3).getNumericCellValue()) + "";
                    Staff staff = new Staff(id, name, majorId, instituteId, null, null, null);
                    System.out.println(staff);
                } catch (NullPointerException e) {
                    System.out.println("信息不全");
                }catch (Exception e1){
                    System.out.println("检查类型");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    /**
     * 生成批量导入教职工信息模板表
     */
    @Test
    public void test03() throws IOException {
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

        /**
         * 输出
         */
        FileOutputStream outputStream = new FileOutputStream("E:\\教职工信息表.xls");
        wb.write(outputStream);
        outputStream.flush();
    }

    /**
     * 处理导入教材征订计划表
     */
    @Test
    public void test02() {

        String fileName = "E:\\教材征订计划表样例.xlsx";

        Workbook wb;
        Sheet sheet;
        Row row;
        String content;

        try {
            wb = PoiUtil.getWorkbook(fileName);

            sheet = wb.getSheetAt(0);
            /**
             * 获取标题
             */
            row = sheet.getRow(0);
            content = row.getCell(0).getStringCellValue();
            System.out.println(content);

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

            /**
             * 表格首部
             */
//            row = sheet.getRow(3);
//            row.getLastCellNum(),获取列数比最后一列列标大1
//            for (int i=row.getLastCellNum()-2;i>=0;i--){
//                content = row.getCell(i).getStringCellValue();
//                System.out.println(content);
//            }

            /**
             * 表格内容
             */
            row = sheet.getRow(27);
//            System.out.println(PoiUtil.double2Int(row.getCell(10).getNumericCellValue()));
//            System.out.println(String.valueOf(row.getCell(12).getNumericCellValue()).replace(".","").split("E")[0]);
//            System.out.println(row.getCell(12).getStringCellValue().replace(" ",",").replace("\n",","));
            BookPurchasingSchedule schedule = new BookPurchasingSchedule(
                    PoiUtil.double2Int(row.getCell(0).getNumericCellValue()), //序号
                    row.getCell(1).getStringCellValue().replace(" ", "").replace("\n", ""), //课程名称
                    row.getCell(2).getStringCellValue().replace(" ", "").replace("\n", ""), //教材名称
                    row.getCell(3).getStringCellValue().replace(" ", "").replace("\n", ""), //书号
                    row.getCell(4).getStringCellValue().replace(" ", "").replace("\n", ","), //出版社/作者
                    row.getCell(5).getStringCellValue(), //出版时间
                    row.getCell(6).getStringCellValue().replace(" ", ",").replace("\n", ","), //教材等级
                    row.getCell(7).getNumericCellValue(), //单价
                    row.getCell(8).getStringCellValue().replace(" ", ",").replace("\n", ","), //使用年级、专业及方向
                    PoiUtil.double2Int(row.getCell(9).getNumericCellValue()), //学生数量
                    PoiUtil.double2Int(row.getCell(10).getNumericCellValue()), //教师领用量
                    row.getCell(11).getStringCellValue(), //选用人
                    String.valueOf(row.getCell(12).getNumericCellValue()).replace(".", "").split("E")[0],//联系电话
                    row.getCell(13).getStringCellValue(),//备注
                    "2017-2018学年第二学期",
                    "计算机学院",
                    "必修课",
                    ""
            );
            System.out.println(schedule);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 生成教材征订计划表
     */
    @Test
    public void test01() throws IOException {
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

        /**
         * 输出
         */
        FileOutputStream outputStream = new FileOutputStream("E:\\北京理工大学珠海学院2018-2019学年第二学期教材征订计划表.xls");
        wb.write(outputStream);
        outputStream.flush();

    }


}

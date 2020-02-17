package com.ddu.goushushenpixitong.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 操作poi的工具类
 */
public class PoiUtil {

    private static final Logger logger = LoggerFactory.getLogger(PoiUtil.class);

    private final static String excel2003L = ".xls";
    private final static String excel2007U = ".xlsx";

    /**
     * 设置字体样式
     *
     * @param wb             excel的文档对象
     * @param fontName       字体样式
     * @param heightInPoints 字体高度
     * @param isBold         是否加粗
     * @return
     */
    public static HSSFFont setFontStyle(HSSFWorkbook wb, String fontName, Short heightInPoints, Boolean isBold) {
        HSSFFont fontStyle = wb.createFont();
        fontStyle.setFontName(fontName);
        fontStyle.setFontHeightInPoints(heightInPoints);
        fontStyle.setBold(isBold);
        return fontStyle;
    }

    /**
     * 设置单元格样式
     *
     * @param wb                  excel的文档对象
     * @param horizontalAlignment 水平位置
     * @param verticalAlignment   垂直位置
     * @param isWrapText          是否自动换行
     * @return
     */
    public static HSSFCellStyle setHSSFCellStyle(HSSFWorkbook wb, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, Boolean isWrapText) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(horizontalAlignment);
        cellStyle.setVerticalAlignment(verticalAlignment);
        cellStyle.setWrapText(isWrapText);
        return cellStyle;
    }

    /**
     * @param cellStyle
     * @param fontStyle
     * @return
     */
    public static HSSFCellStyle getHSSFCellStyle(HSSFCellStyle cellStyle, HSSFFont fontStyle) {
        cellStyle.setFont(fontStyle);
        return cellStyle;
    }

    /**
     * 导出excel
     *
     * @param wb       excel的文档对象
     * @param fileName 导出的名称
     * @param response Http响应
     */
    public static void export(HSSFWorkbook wb, String fileName, HttpServletResponse response) {

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        try {
            response.setHeader("Content-disposition", "attachment;filename="
                    + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        } catch (UnsupportedEncodingException e1) {
            logger.info(e1.getMessage());
        }

        /**
         * 将文件输出
         */
        try {
            OutputStream outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            logger.info("导出Excel失败！");
            logger.error(e.getMessage());
        }

    }

    /**
     * 判断文件类型是不是2003版本
     *
     * @param filePath
     * @return
     */
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * 判断文件类型是不是2007版本
     *
     * @param filePath
     * @return
     */
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    public static Integer double2Int(Double num) {
        return new Double(num).intValue();
    }

    /**
     * 通过文件后缀自动声明相应对象(适合本地)
     *
     * @param fileName 绝对路径
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook(String fileName) throws IOException {
        Workbook wb;
        String ext = fileName.substring(fileName.lastIndexOf("."));
        InputStream is = new FileInputStream(fileName);
        ZipSecureFile.setMinInflateRatio(-1.0d);
        if (excel2003L.equals(ext)) {
            wb = new HSSFWorkbook(is);
        } else if (excel2007U.equals(ext)) {
            wb = new XSSFWorkbook(is);
        } else {
            wb = null;
        }
        return wb;
    }


    public static Workbook getWorkbooks(MultipartFile file,String fileName) throws IOException {
        Workbook wb;
        String ext = fileName.substring(fileName.lastIndexOf("."));
        InputStream is = file.getInputStream();
        ZipSecureFile.setMinInflateRatio(-1.0d);
        if (excel2003L.equals(ext)) {
            wb = new HSSFWorkbook(is);
        } else if (excel2007U.equals(ext)) {
            wb = new XSSFWorkbook(is);
        } else {
            wb = null;
        }
        return wb;
    }

    /**
     * 根据文件后缀，自适应上传文件的版本（适合网络）
     *
     * @param instr
     * @param fileName
     * @return
     * @throws Exception
     */
    public static Workbook getWorkbook(InputStream instr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(instr);
        } else if (excel2007U.equals(fileType)) {
            wb = new XSSFWorkbook(instr);
        } else {
            throw new Exception("解析的文件格式有误!");
        }
        return wb;
    }



    /**
     * 设置某些列的值只能输入预制的数据,显示下拉框.
     *
     * @param sheet
     *            要设置的sheet.
     * @param textlist
     *            下拉框显示的内容
     * @param firstRow
     *            开始行
     * @param endRow
     *            结束行
     * @param firstCol
     *            开始列
     * @param endCol
     *            结束列
     * @return 设置好的sheet.
     */
    public static HSSFSheet setHSSFValidation(HSSFSheet sheet, String[] textlist, int firstRow,
                                              int endRow, int firstCol, int endCol) {
        // 加载下拉列表内容
        DVConstraint constraint = DVConstraint
                .createExplicitListConstraint(textlist);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow,
                endRow, firstCol, endCol);
        // 数据有效性对象
        HSSFDataValidation data_validation_list = new HSSFDataValidation(
                regions, constraint);
        sheet.addValidationData(data_validation_list);
        return sheet;
    }

    /**
     * 设置单元格上提示
     *
     * @param sheet
     *            要设置的sheet.
     * @param promptTitle
     *            标题
     * @param promptContent
     *            内容
     * @param firstRow
     *            开始行
     * @param endRow
     *            结束行
     * @param firstCol
     *            开始列
     * @param endCol
     *            结束列
     * @return 设置好的sheet.
     */
    public static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle,
                                          String promptContent, int firstRow, int endRow, int firstCol,
                                          int endCol) {
        // 构造constraint对象
        DVConstraint constraint = DVConstraint
                .createCustomFormulaConstraint("BB1");
        // 四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow,
                endRow, firstCol, endCol);
        // 数据有效性对象
        HSSFDataValidation data_validation_view = new HSSFDataValidation(
                regions, constraint);
        data_validation_view.createPromptBox(promptTitle, promptContent);
        sheet.addValidationData(data_validation_view);
        return sheet;
    }


}

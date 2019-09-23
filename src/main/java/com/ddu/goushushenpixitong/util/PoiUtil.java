package com.ddu.goushushenpixitong.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

}

package com.ddu.goushushenpixitong.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * freemaker工具类
 */
public class FreemakerUtil {

    private static final Logger logger = LoggerFactory.getLogger(PoiUtil.class);

    /**
     * 获取 *.ftl 模板
     * tip： 模板默认从 /templates目录下寻找
     *
     * @param fileName 模板名
     * @return
     * @throws IOException
     */
    public static Template getTemplate(String fileName) throws IOException {
        Configuration configuration = new Configuration(new Version("2.3.0"));
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(FreemakerUtil.class, "/templates");

        Template template = configuration.getTemplate(fileName, "utf-8");

        return template;
    }

    /**
     * 导出word文档
     *
     * @param template 模板对象
     * @param fileName 导出文件名（不带后缀）
     * @param dataMap  数据集合
     * @param response 响应头
     */
    public static void exportDoc(Template template, String fileName,
                                 Map<String, String> dataMap, HttpServletResponse response) {

        response.reset();
        response.setContentType("application/force-download");

        try {
            response.addHeader("Content-disposition", "attachment;filename="
                    + new String((fileName + ".doc").getBytes(), "iso-8859-1"));
        } catch (UnsupportedEncodingException e1) {
            logger.info(e1.getMessage());
        }

        try {
            OutputStream outputStream = response.getOutputStream();
            Writer out = new BufferedWriter(new OutputStreamWriter(outputStream));
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            logger.info("导出Word失败！");
            logger.error(e.getMessage());
        }


    }

}

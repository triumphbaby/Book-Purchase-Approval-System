package com.ddu.goushushenpixitong.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FreemakerTest extends BaseTest {


    @Test
    public void testexportApprovalForm() throws IOException, TemplateException {
        Map<String, String> dataMap = new HashMap<String, String>();

        ApprovalFormUtil.setTerm(dataMap, "2019-2020学年第一学期");
        ApprovalFormUtil.setInstitute(dataMap, "计算机学院");
        ApprovalFormUtil.setCourseName(dataMap, "数字图像处理");
        ApprovalFormUtil.setCourseId(dataMap, "02170001");
        ApprovalFormUtil.setCourseCharacter(dataMap, false);
        ApprovalFormUtil.setBookName(dataMap, "MATLAB图像处理编程与应用");
        ApprovalFormUtil.setCoursePeriod(dataMap, "48");
        ApprovalFormUtil.setCourseCredit(dataMap, "2");
        ApprovalFormUtil.setBookAuthor(dataMap, "张涛");
        ApprovalFormUtil.setBookPublisher(dataMap, "机械工业出版社");
        ApprovalFormUtil.setBookId(dataMap, "9787111461371");
        ApprovalFormUtil.setBookPublishDate(dataMap, "2014.04");
        ApprovalFormUtil.setBookEdition(dataMap, "1");
        ApprovalFormUtil.setBookPrintingDate(dataMap, "2014");
        ApprovalFormUtil.setBookLevel(dataMap, 4, null);
        ApprovalFormUtil.setUsableMajor(dataMap, "计算机学院数字媒体技术专业");
        ApprovalFormUtil.setUsableGrade(dataMap, "2年级");
        ApprovalFormUtil.setUsableClass(dataMap, "1-2");
        ApprovalFormUtil.setUsableTerm(dataMap, "2019-2020-1");
        ApprovalFormUtil.setReasonForBook(dataMap, "是比较权威教材【高等院校EDA系列教材】，并配有处理环境matlab的介绍");
        ApprovalFormUtil.setRenew(dataMap, false);
        ApprovalFormUtil.setSignatureDateOfTeacher(dataMap, "年   月   日");

        dataMap.put("ii1", "教材是否符合教学大纲要求");
        dataMap.put("ii2", "教材内容是否反映了本学科的先进成果");
        dataMap.put("ii3", "是否选用国家规划教材或教育部推荐教材");
        dataMap.put("ii4", "是否选用同行公认的优质教材");
        dataMap.put("ii5", "是否选用近三年出版（或修订）的教材");
        dataMap.put("ii6", "相同教学要求的同一门课程是否使用相同教材");

        dataMap.put("i1", "□");
        dataMap.put("i2", "□");
        dataMap.put("i3", "□");
        dataMap.put("i4", "□");
        dataMap.put("i5", "□");
        dataMap.put("i6", "□");
        dataMap.put("i7", "□");
        dataMap.put("i8", "□");
        dataMap.put("i9", "□");
        dataMap.put("i10", "□");
        dataMap.put("i11", "□");
        dataMap.put("i12", "□");
        dataMap.put("i13", "年   月   日");

        dataMap.put("jj1", "教研室（课程组）是否按教材选用制度选用教材");
        dataMap.put("j1", "□");
        dataMap.put("j2", "□");
        dataMap.put("j3", "年   月   日");

        dataMap.put("kk1", "选用教材程序是否符合要求");
        dataMap.put("kk2", "是否同意订购选用教材");
        dataMap.put("k1", "□");
        dataMap.put("k2", "□");
        dataMap.put("k3", "□");
        dataMap.put("k4", "□");
        dataMap.put("k5", "年   月   日");

        File outFile = new File("E:/test.doc");

        Template t = FreemakerUtil.getTemplate("ApprovalForm.ftl");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
        t.process(dataMap, out);
        out.close();
    }

    @Test
    public void exportSimpleWord() throws IOException, TemplateException {
        // 要填充的数据, 注意map的key要和word中${xxx}的xxx一致
        Map<String, String> dataMap = new HashMap<String, String>();

        dataMap.put("courseName", "数字图像处理");
        dataMap.put("bookName", "MATLAB图像处理编程与应用");
        dataMap.put("level1", "■");
        dataMap.put("level2", "□");
        dataMap.put("majorName", "计算机学院数字媒体技术专业");
        dataMap.put("majorGrade", "2年级");
        dataMap.put("majorClass", "1-2");
        dataMap.put("termName", "2019-2020-1");

        //Configuration用于读取ftl文件
        Configuration configuration = new Configuration(new Version("2.3.0"));
        configuration.setDefaultEncoding("utf-8");

        /**
         * 以下是两种指定ftl文件所在目录路径的方式, 注意这两种方式都是
         * 指定ftl文件所在目录的路径,而不是ftl文件的路径
         */
        //基于类路径
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");

        //基于文件系统
//        configuration.setDirectoryForTemplateLoading(new File("E:/"));


        // 输出文档路径及名称
        File outFile = new File("E:/test.doc");

        //以utf-8的编码读取ftl文件
        Template t = configuration.getTemplate("test.ftl", "utf-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
        t.process(dataMap, out);
        out.close();
    }


}

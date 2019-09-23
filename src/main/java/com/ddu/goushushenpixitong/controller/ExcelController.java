package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.service.ExcelService;
import com.ddu.goushushenpixitong.util.CommonResult;
import com.ddu.goushushenpixitong.util.FreemakerUtil;
import com.ddu.goushushenpixitong.util.PoiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExcelService excelService;

    @GetMapping("/schedule")
    public void exportScheduleTemplate(HttpServletRequest request, HttpServletResponse response) {

        PoiUtil.export(excelService.getBookPurchasingScheduleTemplate(),
                "北京理工大学珠海学院2018-2019学年第二学期教材征订计划表", response);

    }

    @PostMapping("/schedule")
    public CommonResult importSchedule(@RequestParam("file") MultipartFile file) {
//        excelService.uploadBookPurchasingSchedule(file);
        //todo 完成功能
        return null;
    }

    @GetMapping("/approvalform")
    public void exportApprovalForm(HttpServletRequest request, HttpServletResponse response, @RequestParam("subjectId") Integer subjectId) {
        try {
            Map<String, String> dataMap = excelService.prepareApprovalFormData(subjectId);
            FreemakerUtil.exportDoc(FreemakerUtil.getTemplate("ApprovalForm.ftl"), "test", dataMap, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

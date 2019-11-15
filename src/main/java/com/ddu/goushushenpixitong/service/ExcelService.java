package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ExcelService {

    /**
     * 获取教材征订计划表模板
     *
     * @return
     */
    HSSFWorkbook getBookPurchasingScheduleTemplate();

//    Boolean uploadBookPurchasingSchedule(MultipartFile file);

    /**
     * 准备教材选用审批表数据
     *
     * @param subjectId 选课用书id
     * @return
     */
    Map<String, String> prepareApprovalFormData(Integer subjectId);

    CommonResult uploadBookPurchasingSchedule(MultipartFile file);
}

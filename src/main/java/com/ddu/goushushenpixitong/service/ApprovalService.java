package com.ddu.goushushenpixitong.service;

import com.alibaba.fastjson.JSONObject;
import com.ddu.goushushenpixitong.entity.Approval;
import com.ddu.goushushenpixitong.util.CommonResult;

public interface ApprovalService {
    /**
     * 添加审批表
     *
     * @param approval
     * @return
     */
    Boolean add(Approval approval);

    /**
     * 修改
     *
     * @param approval
     * @return
     */
    Boolean modify(Approval approval);

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    Approval findById(Integer id);

    /**
     * 添加教研室审核意见结果
     *
     * @param subjectId 课程用书id
     * @param json      json字符串(科研室审核结果)
     * @return
     */
    CommonResult addLaboratoryOpinions(Integer subjectId, String json);

    /**
     * 获取教研室审核意见结果
     *
     * @param subjectId
     * @return
     */
    JSONObject[] findLaboratoryOpinions(Integer subjectId);

    /**
     * 添加开课教学单位结果
     *
     * @param subjectId
     * @param json
     * @return
     */
    CommonResult addTeachingUnitOpinions(Integer subjectId, String json);

    /**
     * 获取开课教学单位结果
     *
     * @param subjectId
     * @return
     */
    JSONObject[] findTeachingUnitOpinions(Integer subjectId);

    /**
     * 添加教务处审核结果
     *
     * @param subjectId
     * @param json
     * @return
     */
    CommonResult addDeanOfficeOpinions(Integer subjectId, String json);

    /**
     * 获取教务处审核结果
     *
     * @param subjectId
     * @return
     */
    JSONObject[] findDeanOfficeOpinions(Integer subjectId);
}

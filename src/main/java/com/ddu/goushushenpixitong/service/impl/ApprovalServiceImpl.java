package com.ddu.goushushenpixitong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ddu.goushushenpixitong.entity.Approval;
import com.ddu.goushushenpixitong.mapper.ApprovalMapper;
import com.ddu.goushushenpixitong.service.ApprovalService;
import com.ddu.goushushenpixitong.util.CommonResult;
import com.ddu.goushushenpixitong.util.FastjsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    private final static int SUCCESS = 1;

    @Autowired
    private ApprovalMapper approvalMapper;

    @Override
    public Boolean add(Approval approval) {
        try {
            return approvalMapper.insertSelective(approval) == SUCCESS;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean modify(Approval approval) {
        return approvalMapper.updateByPrimaryKeySelective(approval) == SUCCESS;
    }

    @Override
    public Approval findById(Integer subjectId) {
        return approvalMapper.selectByPrimaryKey(subjectId);
    }

    @Override
    public CommonResult addLaboratoryOpinions(Integer subjectId, String json) {
        if (validityCheck(json)) {
            JSONObject[] objects = FastjsonUtil.jsonStr2Array(json);
            if(objects.length != 6)
                return CommonResult.failure("教研室审核意见规定为6个");
            Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
            if (approval == null) {
                approval = new Approval(subjectId, json, null, null);
                approvalMapper.insertSelective(approval);
            } else {
                approval.setOptionLab(json);
                approvalMapper.updateByPrimaryKeySelective(approval);
            }
            return CommonResult.success();
        }
        return CommonResult.failure("格式错误");
    }

    @Override
    public JSONObject[] findLaboratoryOpinions(Integer subjectId) {
        Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
        String jsonStr = approval.getOptionLab();
        return FastjsonUtil.jsonStr2Array(jsonStr);
    }

    @Override
    public CommonResult addTeachingUnitOpinions(Integer subjectId, String json) {
        if (validityCheck(json)) {
            JSONObject[] objects = FastjsonUtil.jsonStr2Array(json);
            if(objects.length != 1)
                return CommonResult.failure("开课教学单位结果规定为1个");
            Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
            if (approval == null) {
                approval = new Approval(subjectId, null, json, null);
                approvalMapper.insertSelective(approval);
            } else {
                approval.setOptionUnit(json);
                approvalMapper.updateByPrimaryKeySelective(approval);
            }
            return CommonResult.success();
        }
        return CommonResult.failure("格式错误");
    }

    @Override
    public JSONObject[] findTeachingUnitOpinions(Integer subjectId) {
        Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
        String jsonStr = approval.getOptionUnit();
        return FastjsonUtil.jsonStr2Array(jsonStr);
    }

    @Override
    public CommonResult addDeanOfficeOpinions(Integer subjectId, String json) {
        if (validityCheck(json)) {
            JSONObject[] objects = FastjsonUtil.jsonStr2Array(json);
            if(objects.length != 2)
                return CommonResult.failure("教务处审核结果规定为2个");
            Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
            if (approval == null) {
                approval = new Approval(subjectId, null, null, json);
                approvalMapper.insertSelective(approval);
            } else {
                approval.setOptionDean(json);
                approvalMapper.updateByPrimaryKeySelective(approval);
            }
            return CommonResult.success();
        }
        return CommonResult.failure("格式错误");
    }

    @Override
    public JSONObject[] findDeanOfficeOpinions(Integer subjectId) {
        Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
        String jsonStr = approval.getOptionDean();
        return FastjsonUtil.jsonStr2Array(jsonStr);
    }

    /**
     * 验证json是否符合要求
     *
     * @param jsonStr
     * @return
     */
    private static Boolean validityCheck(String jsonStr) {
        try {
            JSONObject[] jsonObjects = FastjsonUtil.jsonStr2Array(jsonStr);
            int len = jsonObjects.length;
            Boolean isCorrect = true;
            Set<Integer> iSet = new TreeSet<>(); //存放id
            for (JSONObject jo : jsonObjects) {
                System.out.println(jo.isEmpty());
                    if (iSet.contains(jo.getInteger("id"))) {
                        isCorrect = false;
                        break;
                    } else {
                        iSet.add(jo.getInteger("id"));
                    }
                    if (!jo.getString("opinion").matches("yes") &&
                            !jo.getString("opinion").matches("no")) {
                        isCorrect = false;
                        break;
                    }
            }
            return isCorrect;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

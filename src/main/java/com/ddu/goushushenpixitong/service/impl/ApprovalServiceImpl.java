package com.ddu.goushushenpixitong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ddu.goushushenpixitong.entity.Approval;
import com.ddu.goushushenpixitong.mapper.ApprovalMapper;
import com.ddu.goushushenpixitong.service.ApprovalService;
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
    public Boolean addLaboratoryOpinions(Integer subjectId, String json) {
        if (validityCheck(json)) {
            Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
            if (approval == null) {
                approval = new Approval(subjectId, json, null, null);
                approvalMapper.insertSelective(approval);
            } else {
                approval.setOptionLab(json);
                approvalMapper.updateByPrimaryKeySelective(approval);
            }
            return true;
        }
        return false;
    }

    @Override
    public JSONObject[] findLaboratoryOpinions(Integer subjectId) {
        Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
        String jsonStr = approval.getOptionLab();
        return FastjsonUtil.jsonStr2Array(jsonStr);
    }

    @Override
    public Boolean addTeachingUnitOpinions(Integer subjectId, String json) {
        if (validityCheck(json)) {
            Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
            if (approval == null) {
                approval = new Approval(subjectId, null, json, null);
                approvalMapper.insertSelective(approval);
            } else {
                approval.setOptionUnit(json);
                approvalMapper.updateByPrimaryKeySelective(approval);
            }
            return true;
        }
        return false;
    }

    @Override
    public JSONObject[] findTeachingUnitOpinions(Integer subjectId) {
        Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
        String jsonStr = approval.getOptionUnit();
        return FastjsonUtil.jsonStr2Array(jsonStr);
    }

    @Override
    public Boolean addDeanOfficeOpinions(Integer subjectId, String json) {
        if (validityCheck(json)){
            Approval approval = approvalMapper.selectByPrimaryKey(subjectId);
            if (approval == null){
                approval = new Approval(subjectId,null,null,json);
                approvalMapper.insertSelective(approval);
            }else {
                approval.setOptionDean(json);
                approvalMapper.updateByPrimaryKeySelective(approval);
            }
            return true;
        }
        return false;
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
            Boolean isCorrect = true;
            Set<Integer> iSet = new TreeSet<>(); //存放id
            for (JSONObject jo : jsonObjects) {
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

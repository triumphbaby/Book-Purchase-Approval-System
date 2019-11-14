package com.ddu.goushushenpixitong.service;

import com.alibaba.fastjson.JSONObject;
import com.ddu.goushushenpixitong.entity.Approval;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.TreeSet;

public class ApprovalServiceTest extends BaseTest {

    @Autowired
    private ApprovalService approvalService;

    @Test
    public void testFindLaboratoryOpinions() {
        Integer subjectId = 1;
        for (JSONObject jo : approvalService.findLaboratoryOpinions(subjectId)) {
            Integer id = jo.getInteger("id");
            String res = jo.getString("opinion");
            System.out.println("id=" + id + ",opinion=" + res);
        }
    }

    @Test
    public void testSet() {
        Set<Integer> iSet = new TreeSet<>();
        iSet.add(1);
        iSet.add(1);
        System.out.println(iSet);
    }

    @Test
    public void testAddLaboratoryOpinions() {
        String jsonStr01 = "[{\"id\":6,\"opinion\":\"yes\"},{\"id\":5,\"opinion\":\"yes\"},{\"id\":4,\"opinion\":\"yes\"}]";
        String jsonStr02 = "[{\"id\":a,\"opinion\":\"yes\"},{\"id\":5,\"opinion\":\"yes\"},{\"id\":4,\"opinion\":\"yes\"}]";
        String jsonStr03 = "[{\"id\":6,\"opinion\":\"gg\"},{\"id\":5,\"opinion\":\"yes\"},{\"id\":4,\"opinion\":\"yes\"}]";
        String jsonStr04 = "[{\"id\":6,\"opinion\":\"yes\"},{\"id\":6,\"opinion\":\"yes\"},{\"id\":4,\"opinion\":\"yes\"}]";

        Integer subjectId = 1;

        System.out.println(approvalService.addLaboratoryOpinions(subjectId, jsonStr01));
        System.out.println(approvalService.addLaboratoryOpinions(subjectId, jsonStr02));
        System.out.println(approvalService.addLaboratoryOpinions(subjectId, jsonStr03));
        System.out.println(approvalService.addLaboratoryOpinions(subjectId, jsonStr04));

    }

    @Test
    public void testAdd() {
        Approval approval = new Approval();
        System.out.println(approvalService.add(approval));
    }

}

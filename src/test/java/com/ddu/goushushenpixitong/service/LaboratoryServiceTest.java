package com.ddu.goushushenpixitong.service;

import com.ddu.goushushenpixitong.entity.Laboratory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LaboratoryServiceTest extends BaseTest {

    @Autowired
    private LaboratoryService laboratoryService;

    @Test
    public void testAdd() {
        Laboratory laboratory = new Laboratory(null, "test", null);
        System.out.println(laboratoryService.add(laboratory));
        System.out.println(laboratory.getId());
    }

    @Test
    public void testModify() {
        Laboratory laboratory = laboratoryService.findById(1);
        laboratory.setRemarks("ddd");
        System.out.println(laboratoryService.modify(laboratory));
    }

    @Test
    public void testFindLaboratoryByPage() {
        for (Laboratory l : laboratoryService.findLaboratoryByPage(0, 3)
        ) {
            System.out.println(l);
        }
    }

}

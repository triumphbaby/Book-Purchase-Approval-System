package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Term;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TermMapperTest extends BaseTest {

    @Autowired
    private TermMapper termMapper;

    @Test
    public void testGetAbbreviation(){
        Term term = termMapper.selectByPrimaryKey(1);
        System.out.println(Term.getAbbreviation(term.getName()));
    }

}

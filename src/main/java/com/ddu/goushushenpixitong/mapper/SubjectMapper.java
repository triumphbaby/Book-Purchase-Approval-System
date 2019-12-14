package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.entity.Subject;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SubjectMapper extends Mapper<Subject> {

    @Select("SELECT * FROM SUBJECT WHERE institute_id = #{insititudeId}")
    List<Subject> getSubjectByInstituteId(String insititudeId);


}
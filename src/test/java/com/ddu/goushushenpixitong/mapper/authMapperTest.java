package com.ddu.goushushenpixitong.mapper;

import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.mapper.AuthMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-02-02 02
 */
public class authMapperTest extends BaseTest {

    @Autowired
    AuthMapper authMapper;

    @Test
    public void getAll(){

        List<AuthDAO> result = authMapper.getAllStaff_RoleAndPower();
        for (AuthDAO a:result) {
            System.out.println(a);
        }
    }


    @Test
    public void getStaff_RoleAndPower(){
        List<AuthDAO> result = authMapper.getStaff_RoleAndPower("1003");
        System.out.println(result);
    }

}

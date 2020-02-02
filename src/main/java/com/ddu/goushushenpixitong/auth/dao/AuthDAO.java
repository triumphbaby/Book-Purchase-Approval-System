package com.ddu.goushushenpixitong.auth.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;

/**
 * 用于记录人员权限
 * @auther ChunKitAu
 * @create 2020-02-01 01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDAO {
    //人员id
    private String id;
    //人员姓名
    private String name;
    //人员角色
    private String role;
    //人员权限
    private String power;
}

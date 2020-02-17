package com.ddu.goushushenpixitong.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@Data
@AllArgsConstructor
/**
 * @auther ChunKitAu
 * @create 2020-01-29 15
 */
public class Staff_Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "staff_id")
    private String staffId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

}
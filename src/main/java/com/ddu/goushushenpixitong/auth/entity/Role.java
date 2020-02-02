package com.ddu.goushushenpixitong.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @auther ChunKitAu
 * @create 2020-01-29 15
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色类型
     */
    private String type;

    /**
     * 备注
     */
    private String remarks;

}
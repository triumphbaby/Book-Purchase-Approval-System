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
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限名
     */
    @Column(name = "powerName")
    private String powerName;

    /**
     * 备注
     */
    private String remarks;


}
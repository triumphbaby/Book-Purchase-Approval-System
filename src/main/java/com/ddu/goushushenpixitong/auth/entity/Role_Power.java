package com.ddu.goushushenpixitong.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * @auther ChunKitAu
 * @create 2020-01-29 15
 */
public class Role_Power {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限id
     */
    @Column(name = "powr_id")
    private Integer powrId;


}
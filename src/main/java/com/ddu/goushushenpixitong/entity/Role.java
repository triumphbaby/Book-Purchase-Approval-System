package com.ddu.goushushenpixitong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 角色
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Role {
    /**
     * 工号
     */
    @Id
    @NotNull(message = "id不能为空")
    private String id;

    /**
     * 角色类型
     */
    @NotNull(message = "type不能为空")
    private Integer type;

    /**
     * 备注
     */
    private String remarks;

}
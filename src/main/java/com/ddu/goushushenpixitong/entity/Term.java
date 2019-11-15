package com.ddu.goushushenpixitong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 学期
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Term {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学期名称
     */
    @NotNull(message = "name不能为空")
    private String name;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 获得学期的简写
     * 例如：2019-2020第一学期 --> 2019-2020-1
     *
     * @param termName
     * @return
     */
    public static String getAbbreviation(String termName) {
        String subStr = termName.split("第")[0];
        if (termName.contains("一")) {
            subStr += "-1";
        } else {
            subStr += "-2";
        }
        return subStr;
    }

}
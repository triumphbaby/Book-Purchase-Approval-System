package com.ddu.goushushenpixitong.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @auther ChunKitAu
 * @create 2020-02-09 09
 */
@AllArgsConstructor
@Getter
public enum  insituteEnum {

    AVIATION( "航空学院","HK1011"),
    ITACADEMY( "计算机学院","JS001"),
    BUSINESS( "商学院","S10211"),
    INFORMATION( "信息学院","XX1052"),
    ART("艺术学院","YS1025");

    private String insitute;
    private String insituteId;

    /**
     * 根据类型返回对应的枚举对象
     *
     * @param type 类型
     * @return
     */
    public static String insituteTypeOf(String type) {
        for (insituteEnum questionType : values()) {
            if (questionType.getInsitute().equals(type)) {
                return questionType.getInsituteId();
            }
        }
        return null;
    }

}

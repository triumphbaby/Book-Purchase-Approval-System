package com.ddu.goushushenpixitong.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.security.Security;

/**
 * @auther ChunKitAu
 * @create 2020-02-10 10
 */
@Getter
@AllArgsConstructor
public enum majorEnum {

    ARTIFICIAL_INTELLIGENCE( "人工智能","XXR001"),
    COMMUNICATION_TECHNOLOGY( "通信技术","XXT001"),
    INFORMATION_SECURITY_TECHNOLOGY( "信息安全技术","XXT002");

    private String major;
    private String majorId;

    /**
     * 根据类型返回对应的枚举对象
     *
     * @param type 类型
     * @return
     */
    public static String majorTypeOf(String type) {
        for (majorEnum questionType : values()) {
            if (questionType.getMajor().equals(type)) {
                return questionType.getMajorId();
            }
        }
        return null;
    }


}

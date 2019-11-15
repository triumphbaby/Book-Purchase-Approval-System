package com.ddu.goushushenpixitong.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 角色类型
 */
@AllArgsConstructor
@Getter
public enum RoleType {

    ADMIN(0, "管理员"),
    ACADEMIC_DIRECTOR(1, "教务干事"),
    COURSE_DIRECTOR(2, "课程负责人"),
    TEACHING_DEAN(3, "教研室主任");

    private Integer type;
    private String typeInfo;

    /**
     * 根据类型返回对应的枚举对象
     *
     * @param type 类型
     * @return
     */
    public static RoleType typeOf(Integer type) {
        for (RoleType questionType : values()) {
            if (questionType.getType() == type) {
                return questionType;
            }
        }
        return null;
    }

}

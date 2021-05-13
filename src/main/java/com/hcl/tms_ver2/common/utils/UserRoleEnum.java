package com.hcl.tms_ver2.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum UserRoleEnum implements Values {
    EMPLOYEE(1, "Employee"),

    ADMIN_SYS(2, "Admin System"),

    ADMIN_WAREHOUSE(3, "Admin Warehouse");

    private static final Map<Integer, String> BY_ATOMIC_NUMBER = new HashMap<>();

    static {
        for (UserRoleEnum e : values()) {
            BY_ATOMIC_NUMBER.put(e.getCode(), e.getText());
        }
    }

    private final int code;

    private final String text;


    public static String getText(int code) {return BY_ATOMIC_NUMBER.get(code);}
}

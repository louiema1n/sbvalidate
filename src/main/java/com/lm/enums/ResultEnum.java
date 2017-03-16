package com.lm.enums;

/**
 * Created by Louie on 2017-03-16.
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(1, "成功"),
    PRIMARY_SCHOOL(100, "你还在上小学吧"),
    MIDDLE_SCHOOL(101, "你可能在上中学"),
    ;

    private Integer code;

    private String meaasge;

    ResultEnum(Integer code, String meaasge) {
        this.code = code;
        this.meaasge = meaasge;
    }

    public Integer getCode() {
        return code;
    }

    public String getMeaasge() {
        return meaasge;
    }
}

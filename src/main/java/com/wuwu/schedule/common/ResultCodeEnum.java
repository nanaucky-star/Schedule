package com.wuwu.schedule.common;

public enum ResultCodeEnum {
    SUCCESS(200, "SUCCESS"),
    USERNAME_ERROR(501, "USERNAME_ERROR"),
    PASSWORD_ERROR(503, "PASSWORD_ERROR"),
    NOT_LOGIN(504,"NOT_LOGIN"),
    USERNAME_USED(505, "USERNAME_USED"),
    FAIL(-1, "FAIL");
    private Integer code;
    private String msg;

    private ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}

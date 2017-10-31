package com.imooc.girl.enums;

public enum ExceptionEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能在上小学吧"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    ATTRIBUTE_ERROR(1, "属性错误")
    ;

    private Integer code;
    private String message;

    ExceptionEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package com.imooc.girl.exception;

import com.imooc.girl.enums.ExceptionEnum;

public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}

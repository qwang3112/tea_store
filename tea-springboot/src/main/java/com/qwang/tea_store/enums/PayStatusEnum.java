package com.qwang.tea_store.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    UNPIAD(0,"未支付"),
    PAID(1,"已支付");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

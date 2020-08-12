package com.qwang.tea_store.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    TEA_STOCK_ERROR(0,"手机库存不足"),
    ORDER_NOT_EXIST(1,"订单不存在"),
    SPECS_NOT_EXIST(2,"规格不存在"),
    TEA_NOT_EXIST(3,"手机不存在");

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

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

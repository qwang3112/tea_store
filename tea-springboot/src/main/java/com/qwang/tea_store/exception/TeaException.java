package com.qwang.tea_store.exception;

import com.qwang.tea_store.enums.ResultEnum;

public class TeaException extends RuntimeException {
    public TeaException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }

    public TeaException(String error) {
        super(error);
    }
}

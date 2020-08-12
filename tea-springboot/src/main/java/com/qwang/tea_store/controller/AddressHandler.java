package com.qwang.tea_store.controller;

import ch.qos.logback.classic.Logger;
import com.qwang.tea_store.service.AddressService;
import com.qwang.tea_store.vo.ResultVO;
import com.qwang.tea_store.exception.TeaException;
import com.qwang.tea_store.form.AddressForm;
import com.qwang.tea_store.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressHandler {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResultVO list(){
        return ResultVOUtil.success(addressService.findAll());
    }

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Logger log = null;
            log.error("【添加地址】参数错误,addressForm={}",addressForm);
            throw new TeaException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }

    @PutMapping("/update")
    public ResultVO update(@Valid @RequestBody AddressForm addressForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Logger log = null;
            log.error("【修改地址】参数错误,addressForm={}",addressForm);
            throw new TeaException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }
}

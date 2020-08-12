package com.qwang.tea_store.service;

import com.qwang.tea_store.form.AddressForm;
import com.qwang.tea_store.vo.AddressVO;

import java.util.List;

public interface AddressService {
    public List<AddressVO> findAll();
    public void saveOrUpdate(AddressForm addressForm);
}

package com.qwang.tea_store.service.impl;

import com.qwang.tea_store.service.AddressService;
import com.qwang.tea_store.form.AddressForm;
import com.qwang.tea_store.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findAll() {
        List<AddressVO> list = addressService.findAll();
        int id = 0;
    }

    @Test
    void saveOrUpdate(){
        AddressForm addressForm = new AddressForm();
        addressForm.setId(29);
        addressForm.setName("李四");
        addressForm.setTel("13612344321");
        addressForm.setProvince("北京市");
        addressForm.setCity("北京市");
        addressForm.setCounty("东城区");
        addressForm.setAreaCode("110101");
        addressForm.setAddressDetail("168号606室");
        addressService.saveOrUpdate(addressForm);
    }
}
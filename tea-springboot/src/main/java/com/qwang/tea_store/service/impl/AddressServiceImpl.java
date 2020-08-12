package com.qwang.tea_store.service.impl;

import com.qwang.tea_store.entity.BuyerAddress;
import com.qwang.tea_store.repository.BuyerAddressRepsitory;
import com.qwang.tea_store.service.AddressService;
import com.qwang.tea_store.vo.AddressVO;
import com.qwang.tea_store.form.AddressForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private BuyerAddressRepsitory buyerAddressRepsitory;

    @Override
    public List<AddressVO> findAll() {

        List<AddressVO> list = buyerAddressRepsitory.findAll().stream()
                .map(e -> new AddressVO(
                        e.getAddressId(),
                        e.getAreaCode(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress()
                )).collect(Collectors.toList());

        return list;
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm) {
        BuyerAddress buyerAddress;
        if(addressForm.getId() == null){
            buyerAddress = new BuyerAddress();
        } else {
            buyerAddress = buyerAddressRepsitory.findById(addressForm.getId()).get();
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(stringBuffer.toString());
        buyerAddress.setAreaCode(addressForm.getAreaCode());

        buyerAddressRepsitory.save(buyerAddress);
    }
}

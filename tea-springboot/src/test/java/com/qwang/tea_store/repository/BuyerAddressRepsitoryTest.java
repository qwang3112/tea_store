package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BuyerAddressRepsitoryTest {

    @Autowired
    private BuyerAddressRepsitory repsitory;

    @Test
    void findAll(){
        List<BuyerAddress> list = repsitory.findAll();
        for (BuyerAddress buyerAddress : list) {
            System.out.println(buyerAddress);
        }
    }

    @Test
    void save(){
        BuyerAddress buyerAddress = new BuyerAddress();
        buyerAddress.setAreaCode("330104");
        buyerAddress.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        buyerAddress.setBuyerName("小红");
        buyerAddress.setBuyerPhone("13678787878");
        repsitory.save(buyerAddress);
    }

    @Test
    void update(){
        BuyerAddress buyerAddress = repsitory.findById(35).get();
        buyerAddress.setBuyerName("小明");
        repsitory.save(buyerAddress);
    }
}
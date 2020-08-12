package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    void findAll(){
        List<OrderMaster> list = repository.findAll();
        for (OrderMaster orderMaster : list) {
            System.out.println(orderMaster);
        }
    }

    @Test
    void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        orderMaster.setBuyerPhone("13678787878");
        orderMaster.setOrderAmount(new BigDecimal(200));
        orderMaster.setPayStatus(0);
        orderMaster.setTeaIcon("../static/greentea.jpg");
        orderMaster.setTeaId(1);
        orderMaster.setTeaName("绿茶1");
        orderMaster.setTeaQuantity(2);
        orderMaster.setSpecsId(1);
        orderMaster.setSpecsName("1斤装");
        orderMaster.setSpecsPrice(new BigDecimal(10000));
        repository.save(orderMaster);
    }

    @Test
    void findById(){
        OrderMaster orderMaster = repository.findById("123456").get();
        System.out.println(orderMaster);
    }

    @Test
    void pay(){
        OrderMaster orderMaster = repository.findById("123456").get();
        orderMaster.setPayStatus(1);
        repository.save(orderMaster);
    }
}
package com.qwang.tea_store.service.impl;

import com.qwang.tea_store.service.OrderService;
import com.qwang.tea_store.dto.OrderDTO;
import com.qwang.tea_store.vo.OrderDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("13678787878");
        orderDTO.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        orderDTO.setSpecsId(1);
        orderDTO.setTeaQuantity(1);

        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);
    }

    @Test
    void findDetail(){
        OrderDetailVO orderDetailVO = orderService.findOrderDetailByOrderId("1586492591082686753");
        int id = 10;
    }

    @Test
    void pay(){
        System.out.println(orderService.pay("1586492591082686753"));
    }
}
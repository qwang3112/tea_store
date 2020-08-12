package com.qwang.tea_store.service;

import com.qwang.tea_store.dto.OrderDTO;
import com.qwang.tea_store.vo.OrderDetailVO;

public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);
    public OrderDetailVO findOrderDetailByOrderId(String orderId);
    public String pay(String orderId);
}

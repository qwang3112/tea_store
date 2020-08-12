package com.qwang.tea_store.service.impl;

import ch.qos.logback.classic.Logger;
import com.qwang.tea_store.entity.TeaInfo;
import com.qwang.tea_store.entity.TeaSpecs;
import com.qwang.tea_store.enums.PayStatusEnum;
import com.qwang.tea_store.enums.ResultEnum;
import com.qwang.tea_store.exception.TeaException;
import com.qwang.tea_store.repository.OrderMasterRepository;
import com.qwang.tea_store.repository.TeaInfoRepository;
import com.qwang.tea_store.repository.TeaSpecsRepository;
import com.qwang.tea_store.service.OrderService;
import com.qwang.tea_store.service.TeaService;
import com.qwang.tea_store.dto.OrderDTO;
import com.qwang.tea_store.entity.OrderMaster;
import com.qwang.tea_store.util.KeyUtil;
import com.qwang.tea_store.vo.OrderDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TeaSpecsRepository teaSpecsRepository;
    @Autowired
    private TeaInfoRepository teaInfoRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private TeaService teaService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);

        TeaSpecs teaSpecs = teaSpecsRepository.findById(orderDTO.getSpecsId()).get();
        Logger log = null;
        if(teaSpecs == null){
            log.error("【创建订单】规格不存在,phoneSpecs={}", teaSpecs);
            throw new TeaException(ResultEnum.SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(teaSpecs,orderMaster);

        TeaInfo teaInfo = teaInfoRepository.findById(teaSpecs.getTeaId()).get();
        if(teaInfo == null){
            log.error("【创建订单】手机不存在,phoneInfo={}", teaInfo);
            throw new TeaException(ResultEnum.TEA_NOT_EXIST);
        }
        BeanUtils.copyProperties(teaInfo,orderMaster);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = teaSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getTeaQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(10));
        orderMaster.setOrderAmount(orderAmount);

        //orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //payStatus
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());

        orderMasterRepository.save(orderMaster);

        teaService.subStock(orderDTO.getSpecsId(),orderDTO.getTeaQuantity());

        return orderDTO;
    }

    @Override
    public OrderDetailVO findOrderDetailByOrderId(String orderId) {
        OrderDetailVO orderDetailVO = new OrderDetailVO();

        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if(orderMaster == null){
            Logger log = null;
            log.error("【查询订单】订单不存在,orderMaster={}",orderMaster);
            throw new TeaException(ResultEnum.ORDER_NOT_EXIST);
        }

        BeanUtils.copyProperties(orderMaster,orderDetailVO);
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100))+".00");

        return orderDetailVO;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        Logger log = null;
        if(orderMaster == null){
            log.error("【支付订单】订单不存在,orderMaster={}",orderMaster);
            throw new TeaException(ResultEnum.ORDER_NOT_EXIST);
        }

        if(orderMaster.getPayStatus().equals(PayStatusEnum.UNPIAD.getCode())){
            orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
            orderMasterRepository.save(orderMaster);
        } else {
            log.error("【支付订单】订单已支付,orderMaster={}",orderMaster);
        }

        return orderId;
    }
}

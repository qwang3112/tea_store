package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}

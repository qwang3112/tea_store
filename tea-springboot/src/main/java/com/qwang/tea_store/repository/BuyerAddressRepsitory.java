package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerAddressRepsitory extends JpaRepository<BuyerAddress,Integer> {
}

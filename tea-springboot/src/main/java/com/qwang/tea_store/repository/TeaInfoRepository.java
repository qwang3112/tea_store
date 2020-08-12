package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.TeaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeaInfoRepository extends JpaRepository<TeaInfo,Integer> {
    public List<TeaInfo> findAllByCategoryType(Integer categoryType);
}

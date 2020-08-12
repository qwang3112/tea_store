package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.TeaCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeaCategoryRepository extends JpaRepository<TeaCategory,Integer> {
    public TeaCategory findByCategoryType(Integer categoryType);
}

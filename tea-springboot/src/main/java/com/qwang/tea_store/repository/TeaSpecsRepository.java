package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.TeaSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeaSpecsRepository extends JpaRepository<TeaSpecs,Integer> {
    public List<TeaSpecs> findAllByTeaId(Integer teaId);
}

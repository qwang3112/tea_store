package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.TeaCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeaCategoryRepositoryTest {

    @Autowired
    private TeaCategoryRepository repository;

    @Test
    void findAll(){
        List<TeaCategory> list = repository.findAll();
        for (TeaCategory teaCategory : list) {
            System.out.println(teaCategory);
        }
    }

    @Test
    void findByCategoryType(){
        TeaCategory teaCategory = repository.findByCategoryType(1);
        System.out.println(teaCategory);
    }

}
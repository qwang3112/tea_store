package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.TeaSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeaSpecsRepositoryTest {

    @Autowired
    private TeaSpecsRepository repository;

    @Test
    void findAll(){
        List<TeaSpecs> list = repository.findAll();
        for (TeaSpecs teaSpecs : list) {
            System.out.println(teaSpecs);
        }
    }

    @Test
    void findAllByTeaId(){
        List<TeaSpecs> list = repository.findAllByTeaId(1);
        for (TeaSpecs teaSpecs : list) {
            System.out.println(teaSpecs);
        }
    }

}
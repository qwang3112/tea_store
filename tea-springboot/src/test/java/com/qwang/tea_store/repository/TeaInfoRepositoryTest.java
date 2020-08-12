package com.qwang.tea_store.repository;

import com.qwang.tea_store.entity.TeaInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeaInfoRepositoryTest {

    @Autowired
    private TeaInfoRepository repository;

    @Test
    void findAll(){
        List<TeaInfo> list = repository.findAll();
        for (TeaInfo teaInfo : list) {
            System.out.println(teaInfo);
        }
    }

    @Test
    void findAllByCategoryType(){
        List<TeaInfo> list = repository.findAllByCategoryType(1);
        for (TeaInfo teaInfo : list) {
            System.out.println(teaInfo);
        }
    }

}
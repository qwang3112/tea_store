package com.qwang.tea_store.service.impl;

import com.qwang.tea_store.vo.SpecsPackageVO;
import com.qwang.tea_store.service.TeaService;
import com.qwang.tea_store.vo.DataVO;
import com.qwang.tea_store.vo.TeaInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeaServiceImplTest {

    @Autowired
    private TeaService teaService;

    @Test
    void findDataVO() {
        DataVO dataVO = teaService.findDataVO();
        int id = 0;
    }

    @Test
    void findTeaInfoVOByCategoryType(){
        List<TeaInfoVO> list = teaService.findTeaInfoVOByCategoryType(2);
        int id = 0;
    }

    @Test
    void findSku(){
        SpecsPackageVO specsPackageVO = teaService.findSpecsByTeaId(1);
        int id = 0;
    }

    @Test
    void subStock(){
        teaService.subStock(1,1);
    }
}
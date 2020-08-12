package com.qwang.tea_store.controller;

import com.qwang.tea_store.service.TeaService;
import com.qwang.tea_store.vo.ResultVO;
import com.qwang.tea_store.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tea")
public class TeaHandler {

    @Autowired
    private TeaService teaService;

    @GetMapping("/index")
    public ResultVO index(){
        return ResultVOUtil.success(teaService.findDataVO());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO findByCategoryType(
            @PathVariable("categoryType") Integer categoryType){
        return ResultVOUtil.success(teaService.findTeaInfoVOByCategoryType(categoryType));
    }

    @GetMapping("/findSpecsByTeaId/{teaId}")
    public ResultVO findSpecsByTeaId(
            @PathVariable("teaId") Integer teaId){
        return ResultVOUtil.success(teaService.findSpecsByTeaId(teaId));
    }
}

package com.qwang.tea_store.controller.admin;

import com.qwang.tea_store.entity.TeaInfo;
import com.qwang.tea_store.repository.TeaInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/teaInfo")
public class TeaInfoHandler {
    @Autowired
    private TeaInfoRepository teaInfoRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<TeaInfo> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return teaInfoRepository.findAll(request);
    }

    @PostMapping("/save")
    public String save(@RequestBody TeaInfo teaInfo){
        teaInfo.setCreateTime(new Date());
        teaInfo.setUpdateTime(new Date());
        TeaInfo result = teaInfoRepository.save(teaInfo);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public TeaInfo findById(@PathVariable("id") Integer id){
        return teaInfoRepository.findById(id).get();
    }


    @PutMapping("/update")
    public String update(@RequestBody TeaInfo teaInfo){
        TeaInfo teaInfo1 = teaInfoRepository.findById(teaInfo.getTeaId()).get();
        teaInfo.setCreateTime(teaInfo1.getCreateTime());
        teaInfo.setUpdateTime(new Date());
        TeaInfo result = teaInfoRepository.save(teaInfo);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        teaInfoRepository.deleteById(id);
    }
}

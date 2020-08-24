package com.qwang.tea_store.controller.admin;


import com.qwang.tea_store.entity.TeaCategory;
import com.qwang.tea_store.repository.TeaCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/teaInfo")
public class TeaCategoryHandler {
    @Autowired
    private TeaCategoryRepository teaCategoryRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<TeaCategory> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return teaCategoryRepository.findAll(request);
    }

    @PostMapping("/save")
    public String save(@RequestBody TeaCategory teaCategory){
        teaCategory.setCreateTime(new Date());
        teaCategory.setUpdateTime(new Date());
        TeaCategory result = teaCategoryRepository.save(teaCategory);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public TeaCategory findById(@PathVariable("id") Integer id){
        return teaCategoryRepository.findById(id).get();
    }


    @PutMapping("/update")
    public String update(@RequestBody TeaCategory teaCategory){
        TeaCategory teaCategory1 = teaCategoryRepository.findById(teaCategory.getCategoryId()).get();
        teaCategory.setCreateTime(teaCategory1.getCreateTime());
        teaCategory.setUpdateTime(new Date());
        TeaCategory result = teaCategoryRepository.save(teaCategory);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        teaCategoryRepository.deleteById(id);
    }
}

package com.qwang.tea_store.controller.admin;

import com.qwang.tea_store.entity.TeaSpecs;
import com.qwang.tea_store.repository.TeaSpecsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/teaSpecs")
public class TeaSpecsHandler {
    @Autowired
    private TeaSpecsRepository teaSpecsRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<TeaSpecs> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return teaSpecsRepository.findAll(request);
    }

    @PostMapping("/save")
    public String save(@RequestBody TeaSpecs teaSpecs){
        TeaSpecs result = teaSpecsRepository.save(teaSpecs);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public TeaSpecs findById(@PathVariable("id") Integer id){
        return teaSpecsRepository.findById(id).get();
    }


    @PutMapping("/update")
    public String update(@RequestBody TeaSpecs teaSpecs){
        TeaSpecs result = teaSpecsRepository.save(teaSpecs);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        teaSpecsRepository.deleteById(id);
    }
}

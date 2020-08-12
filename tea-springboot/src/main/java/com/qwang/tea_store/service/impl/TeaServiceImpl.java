package com.qwang.tea_store.service.impl;

import ch.qos.logback.classic.Logger;
import com.qwang.tea_store.entity.TeaCategory;
import com.qwang.tea_store.entity.TeaInfo;
import com.qwang.tea_store.entity.TeaSpecs;
import com.qwang.tea_store.enums.ResultEnum;
import com.qwang.tea_store.exception.TeaException;
import com.qwang.tea_store.repository.TeaCategoryRepository;
import com.qwang.tea_store.repository.TeaInfoRepository;
import com.qwang.tea_store.repository.TeaSpecsRepository;
import com.qwang.tea_store.service.TeaService;
import com.qwang.tea_store.util.TeaUtil;
import com.qwang.tea_store.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TeaServiceImpl implements TeaService {

    @Autowired
    private TeaCategoryRepository teaCategoryRepository;
    @Autowired
    private TeaInfoRepository teaInfoRepository;
    @Autowired
    private TeaSpecsRepository teaSpecsRepository;

    @Override
    public DataVO findDataVO() {
        DataVO dataVO = new DataVO();
        //类型
        List<TeaCategory> teaCategoryList = teaCategoryRepository.findAll();
        //常规写法
//        List<PhoneCategoryVO> phoneCategoryVOList = new ArrayList<>();
//        for (PhoneCategory phoneCategory : phoneCategoryList) {
//            PhoneCategoryVO phoneCategoryVO = new PhoneCategoryVO();
//            phoneCategoryVO.setCategoryName(phoneCategory.getCategoryName());
//            phoneCategoryVO.setCategoryType(phoneCategory.getCategoryType());
//            phoneCategoryVOList.add(phoneCategoryVO);
//        }
        //stream
        List<TeaCategoryVO> teaCategoryVOList =  teaCategoryList.stream()
                .map(e -> new TeaCategoryVO(
                        e.getCategoryName(),
                        e.getCategoryType()
                )).collect(Collectors.toList());

        dataVO.setCategories(teaCategoryVOList);

        //手机
        List<TeaInfo> teaInfoList = teaInfoRepository.findAllByCategoryType(teaCategoryList.get(0).getCategoryType());
        //常规写法
//        List<PhoneInfoVO> phoneInfoVOList = new ArrayList<>();
//        for (PhoneInfo phoneInfo : phoneInfoList) {
//            PhoneInfoVO phoneInfoVO = new PhoneInfoVO();
//            BeanUtils.copyProperties(phoneInfo,phoneInfoVO);
//            phoneInfoVO.setTag(PhoneUtil.createTag(phoneInfo.getPhoneTag()));
//            phoneInfoVOList.add(phoneInfoVO);
//        }
        //stream
        List<TeaInfoVO> teaInfoVOList = teaInfoList.stream()
                .map(e -> new TeaInfoVO(
                        e.getTeaId(),
                        e.getTeaName(),
                        e.getTeaPrice()+".00",
                        e.getTeaDescription(),
                        TeaUtil.createTag(e.getTeaTag()),
                        e.getTeaIcon()
                )).collect(Collectors.toList());
        dataVO.setTeas(teaInfoVOList);

        return dataVO;
    }

    @Override
    public List<TeaInfoVO> findTeaInfoVOByCategoryType(Integer categoryType) {
        List<TeaInfo> teaInfoList = teaInfoRepository.findAllByCategoryType(categoryType);
        List<TeaInfoVO> teaInfoVOList = teaInfoList.stream()
                .map(e -> new TeaInfoVO(
                        e.getTeaId(),
                        e.getTeaName(),
                        e.getTeaPrice()+".00",
                        e.getTeaDescription(),
                        TeaUtil.createTag(e.getTeaTag()),
                        e.getTeaIcon()
                )).collect(Collectors.toList());
        return teaInfoVOList;
    }

    @Override
    public SpecsPackageVO findSpecsByTeaId(Integer teaId) {
        TeaInfo teaInfo = teaInfoRepository.findById(teaId).get();
        List<TeaSpecs> teaSpecsList = teaSpecsRepository.findAllByTeaId(teaId);

        //tree
        List<TeaSpecsVO> teaSpecsVOList = new ArrayList<>();
        List<TeaSpecsCasVO> teaSpecsCasVOList = new ArrayList<>();
        TeaSpecsVO teaSpecsVO;
        TeaSpecsCasVO teaSpecsCasVO;
        for (TeaSpecs teaSpecs : teaSpecsList) {
            teaSpecsVO = new TeaSpecsVO();
            teaSpecsCasVO = new TeaSpecsCasVO();
            BeanUtils.copyProperties(teaSpecs, teaSpecsVO);
            BeanUtils.copyProperties(teaSpecs, teaSpecsCasVO);
            teaSpecsVOList.add(teaSpecsVO);
            teaSpecsCasVOList.add(teaSpecsCasVO);
        }
        TreeVO treeVO = new TreeVO();
        treeVO.setV(teaSpecsVOList);
        List<TreeVO> treeVOList = new ArrayList<>();
        treeVOList.add(treeVO);

        SkuVO skuVO = new SkuVO();
        Integer price = teaInfo.getTeaPrice().intValue();
        skuVO.setPrice(price+".00");
        skuVO.setStock_num(teaInfo.getTeaStock());
        skuVO.setTree(treeVOList);
        skuVO.setList(teaSpecsCasVOList);

        SpecsPackageVO specsPackageVO = new SpecsPackageVO();
        specsPackageVO.setSku(skuVO);
        Map<String,String> goods = new HashMap<>();
        goods.put("picture", teaInfo.getTeaIcon());
        specsPackageVO.setGoods(goods);

        return specsPackageVO;
    }

    @Override
    public void subStock(Integer specsId, Integer quantity) {
        TeaSpecs teaSpecs = teaSpecsRepository.findById(specsId).get();
        TeaInfo teaInfo = teaInfoRepository.findById(teaSpecs.getTeaId()).get();
        Integer result = teaSpecs.getSpecsStock() - quantity;
        Logger log = null;
        if(result < 0){
            log.error("【扣库存】库存不足");
            throw new TeaException(ResultEnum.TEA_STOCK_ERROR);
        }

        teaSpecs.setSpecsStock(result);
        teaSpecsRepository.save(teaSpecs);

        result = teaInfo.getTeaStock() - quantity;
        if(result < 0){
            log.error("【扣库存】库存不足");
            throw new TeaException(ResultEnum.TEA_STOCK_ERROR);
        }

        teaInfo.setTeaStock(result);
        teaInfoRepository.save(teaInfo);
    }
}

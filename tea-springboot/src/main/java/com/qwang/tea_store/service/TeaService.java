package com.qwang.tea_store.service;

import com.qwang.tea_store.vo.SpecsPackageVO;
import com.qwang.tea_store.vo.DataVO;
import com.qwang.tea_store.vo.TeaInfoVO;

import java.util.List;

public interface TeaService {
    public DataVO findDataVO();
    public List<TeaInfoVO> findTeaInfoVOByCategoryType(Integer categoryType);
    public SpecsPackageVO findSpecsByTeaId(Integer teaId);
    public void subStock(Integer specsId,Integer quantity);
}

package com.qwang.tea_store.vo;

import lombok.Data;

import java.util.List;

@Data
public class DataVO {
    private List<TeaCategoryVO> categories;
    private List<TeaInfoVO> teas;

    public List<TeaCategoryVO> getCategories() {
        return categories;
    }

    public void setCategories(List<TeaCategoryVO> categories) {
        this.categories = categories;
    }

    public List<TeaInfoVO> getTeas() {
        return teas;
    }

    public void setTeas(List<TeaInfoVO> phones) {
        this.teas = phones;
    }
}

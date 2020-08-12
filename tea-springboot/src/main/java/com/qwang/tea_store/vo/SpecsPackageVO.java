package com.qwang.tea_store.vo;

import lombok.Data;

import java.util.Map;

@Data
public class SpecsPackageVO {
    private Map<String,String> goods;
    private SkuVO sku;

    public Map<String, String> getGoods() {
        return goods;
    }

    public void setGoods(Map<String, String> goods) {
        this.goods = goods;
    }

    public SkuVO getSku() {
        return sku;
    }

    public void setSku(SkuVO sku) {
        this.sku = sku;
    }
}

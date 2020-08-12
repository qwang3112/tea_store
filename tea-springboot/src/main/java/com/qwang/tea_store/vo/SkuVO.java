package com.qwang.tea_store.vo;

import lombok.Data;

import java.util.List;

@Data
public class SkuVO {
    private List<TreeVO> tree;
    private List<TeaSpecsCasVO> list;
    private String price;
    private Integer stock_num;
    private Boolean none_sku = false;
    private Boolean hide_stock = false;

    public List<TreeVO> getTree() {
        return tree;
    }

    public void setTree(List<TreeVO> tree) {
        this.tree = tree;
    }

    public List<TeaSpecsCasVO> getList() {
        return list;
    }

    public void setList(List<TeaSpecsCasVO> list) {
        this.list = list;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStock_num() {
        return stock_num;
    }

    public void setStock_num(Integer stock_num) {
        this.stock_num = stock_num;
    }

    public Boolean getNone_sku() {
        return none_sku;
    }

    public void setNone_sku(Boolean none_sku) {
        this.none_sku = none_sku;
    }

    public Boolean getHide_stock() {
        return hide_stock;
    }

    public void setHide_stock(Boolean hide_stock) {
        this.hide_stock = hide_stock;
    }
}

package com.qwang.tea_store.vo;

import lombok.Data;

import java.util.List;

@Data
public class TreeVO {
    private String k = "规格";
    private List<TeaSpecsVO> v;
    private String k_s = "s1";

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public List<TeaSpecsVO> getV() {
        return v;
    }

    public void setV(List<TeaSpecsVO> v) {
        this.v = v;
    }

    public String getK_s() {
        return k_s;
    }

    public void setK_s(String k_s) {
        this.k_s = k_s;
    }
}

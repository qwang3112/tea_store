package com.qwang.tea_store.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OrderForm {
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "电话不能为空")
    private String tel;
    @NotEmpty(message = "地址不能为空")
    private String address;
    @NotNull(message = "规格不能为空")
    private Integer specsId;
    @NotNull(message = "数量不能为空")
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Integer specsId) {
        this.specsId = specsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

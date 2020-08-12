package com.qwang.tea_store.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class TeaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teaId;
    private String teaName;
    private BigDecimal teaPrice;
    private String teaDescription;
    private Integer teaStock;
    private String teaIcon;
    private Integer categoryType;
    private String teaTag;
    private Date createTime;
    private Date updateTime;

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public BigDecimal getTeaPrice() {
        return teaPrice;
    }

    public void setTeaPrice(BigDecimal teaPrice) {
        this.teaPrice = teaPrice;
    }

    public String getTeaDescription() {
        return teaDescription;
    }

    public void setTeaDescription(String teaDescription) {
        this.teaDescription = teaDescription;
    }

    public Integer getTeaStock() {
        return teaStock;
    }

    public void setTeaStock(Integer teaStock) {
        this.teaStock = teaStock;
    }

    public String getTeaIcon() {
        return teaIcon;
    }

    public void setTeaIcon(String teaIcon) {
        this.teaIcon = teaIcon;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public String getTeaTag() {
        return teaTag;
    }

    public void setTeaTag(String teaTag) {
        this.teaTag = teaTag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

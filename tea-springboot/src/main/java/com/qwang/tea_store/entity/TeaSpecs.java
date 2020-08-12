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
public class TeaSpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specsId;
    private Integer teaId;
    private String specsName;
    private Integer specsStock;
    private BigDecimal specsPrice;
    private String specsIcon;
    private String specsPreview;
    private Date createTime;
    private Date updateTime;

    public Integer getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Integer specsId) {
        this.specsId = specsId;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }

    public Integer getSpecsStock() {
        return specsStock;
    }

    public void setSpecsStock(Integer specsStock) {
        this.specsStock = specsStock;
    }

    public BigDecimal getSpecsPrice() {
        return specsPrice;
    }

    public void setSpecsPrice(BigDecimal specsPrice) {
        this.specsPrice = specsPrice;
    }

    public String getSpecsIcon() {
        return specsIcon;
    }

    public void setSpecsIcon(String specsIcon) {
        this.specsIcon = specsIcon;
    }

    public String getSpecsPreview() {
        return specsPreview;
    }

    public void setSpecsPreview(String specsPreview) {
        this.specsPreview = specsPreview;
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

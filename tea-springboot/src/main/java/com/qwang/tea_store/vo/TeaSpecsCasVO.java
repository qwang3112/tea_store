package com.qwang.tea_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TeaSpecsCasVO {
    @JsonProperty("s1")
    private Integer specsId;
    @JsonProperty("price")
    private BigDecimal specsPrice;
    @JsonProperty("stock_num")
    private Integer specsStock;

    public Integer getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Integer specsId) {
        this.specsId = specsId;
    }

    public BigDecimal getSpecsPrice() {
        return specsPrice;
    }

    public void setSpecsPrice(BigDecimal specsPrice) {
        this.specsPrice = specsPrice;
    }

    public Integer getSpecsStock() {
        return specsStock;
    }

    public void setSpecsStock(Integer specsStock) {
        this.specsStock = specsStock;
    }
}

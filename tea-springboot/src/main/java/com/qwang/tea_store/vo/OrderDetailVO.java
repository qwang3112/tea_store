package com.qwang.tea_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailVO {
    private String orderId;
    private String buyerName;
    @JsonProperty("tel")
    private String buyerPhone;
    @JsonProperty("address")
    private String buyerAddress;
    @JsonProperty("num")
    private Integer teaQuantity;
    private String teaName;
    @JsonProperty("specs")
    private String specsName;
    @JsonProperty("price")
    private String specsPrice;
    @JsonProperty("icon")
    private String teaIcon;
    @JsonProperty("amount")
    private BigDecimal orderAmount;
    private Integer payStatus;
    private Integer freight = 10;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public Integer getTeaQuantity() {
        return teaQuantity;
    }

    public void setTeaQuantity(Integer teaQuantity) {
        this.teaQuantity = teaQuantity;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }

    public String getSpecsPrice() {
        return specsPrice;
    }

    public void setSpecsPrice(String specsPrice) {
        this.specsPrice = specsPrice;
    }

    public String getTeaIcon() {
        return teaIcon;
    }

    public void setTeaIcon(String teaIcon) {
        this.teaIcon = teaIcon;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }
}

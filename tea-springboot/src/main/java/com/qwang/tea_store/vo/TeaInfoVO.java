package com.qwang.tea_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class TeaInfoVO {
    @JsonProperty("id")
    private Integer teaId;
    @JsonProperty("title")
    private String teaName;
    @JsonProperty("price")
    private String teaPrice;
    @JsonProperty("desc")
    private String teaDescription;
    private List<Map<String,String>> tag;
    @JsonProperty("thumb")
    private String teaIcon;

//    public TeaInfoVO(Integer teaId, String teaName, String s, String teaDescription, List<Map<String, String>> tag, String teaIcon) {
//    }

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

    public String getTeaPrice() {
        return teaPrice;
    }

    public void setTeaPrice(String teaPrice) {
        this.teaPrice = teaPrice;
    }

    public String getTeaDescription() {
        return teaDescription;
    }

    public void setTeaDescription(String teaDescription) {
        this.teaDescription = teaDescription;
    }

    public List<Map<String, String>> getTag() {
        return tag;
    }

    public void setTag(List<Map<String, String>> tag) {
        this.tag = tag;
    }

    public String getTeaIcon() {
        return teaIcon;
    }

    public void setTeaIcon(String teaIcon) {
        this.teaIcon = teaIcon;
    }
}

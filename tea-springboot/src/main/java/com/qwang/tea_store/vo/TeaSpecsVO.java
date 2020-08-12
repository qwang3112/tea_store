package com.qwang.tea_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TeaSpecsVO {
    @JsonProperty("id")
    private Integer specsId;
    @JsonProperty("name")
    private String specsName;
    @JsonProperty("imgUrl")
    private String specsIcon;
    @JsonProperty("previewImgUrl")
    private String specsPreview;

    public Integer getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Integer specsId) {
        this.specsId = specsId;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName;
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
}

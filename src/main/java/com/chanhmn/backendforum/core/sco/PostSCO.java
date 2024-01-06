package com.chanhmn.backendforum.core.sco;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class PostSCO extends BaseSCO{

    private Integer id;

    private String topicCode;

    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicCode() {
        return topicCode;
    }

    public void setTopicCode(String topicCode) {
        this.topicCode = topicCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

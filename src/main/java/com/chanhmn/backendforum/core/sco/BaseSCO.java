package com.chanhmn.backendforum.core.sco;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BaseSCO {

    boolean deleteFlag;

    int limit;

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}

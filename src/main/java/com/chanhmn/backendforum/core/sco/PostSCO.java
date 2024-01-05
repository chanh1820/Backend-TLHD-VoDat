package com.chanhmn.backendforum.core.sco;

import lombok.Data;

@Data
public class PostSCO {

    Integer id;

    String topicCode;

    String userId;

    boolean deleteFlag;
}

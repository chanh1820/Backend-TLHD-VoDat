package com.chanhmn.backendforum.core.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TopicDTO {
    private Integer id;

    private String code;

    private String name;

    private LocalDateTime createDate;

    private boolean deleteFlag;
}

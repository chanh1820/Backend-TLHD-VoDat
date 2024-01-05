package com.chanhmn.backendforum.core.dto;

import com.chanhmn.backendforum.entity.PostEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostInteractionDTO {

    private Integer id;

    private String type;

    private String userName;

    private LocalDateTime createDate;

    private PostEntity postEntity;

}

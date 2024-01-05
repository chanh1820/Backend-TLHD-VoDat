package com.chanhmn.backendforum.core.dto;

import com.chanhmn.backendforum.entity.PostEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostCommentDTO {

    private Integer id;

    private String userName;

    private String displayName;

    private String content;

    private LocalDateTime createDate;

    private boolean deleteFlag;

    private PostEntity postEntity;

}

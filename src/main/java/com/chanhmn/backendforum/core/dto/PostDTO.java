package com.chanhmn.backendforum.core.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostDTO {
    private Integer id;

    private String topicCode;

    private String title;

    private String content;

    private String userId;

    private String author;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private boolean deleteFlag;

    private List<PostCommentDTO> postCommentDTOList;

    private List<PostInteractionDTO> postInteractionDTOList;

    private Integer countComment;

    private Integer countInteract;

}

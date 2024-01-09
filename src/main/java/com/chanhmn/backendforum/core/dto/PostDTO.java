package com.chanhmn.backendforum.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateDate;

    private boolean deleteFlag;

    private List<PostCommentDTO> postCommentDTOList;

    private List<PostInteractionDTO> postInteractionDTOList;

    private Integer countComment;

    private Integer countInteract;

    private Boolean isLike;

}

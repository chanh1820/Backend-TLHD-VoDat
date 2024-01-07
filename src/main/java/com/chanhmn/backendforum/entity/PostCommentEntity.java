package com.chanhmn.backendforum.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "post_comment_tbl")
public class PostCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comment_id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "comment_content")
    private String content;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private PostEntity postEntity;

}

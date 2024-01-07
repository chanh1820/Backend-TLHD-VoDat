package com.chanhmn.backendforum.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "post_tbl")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Column(name = "topic_code")
    private String topicCode;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content")
    private String content;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "author")
    private String author;

    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "create_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @OneToMany(mappedBy = "postEntity")
    private List<PostCommentEntity> postCommentEntityList;

    @OneToMany(mappedBy = "postEntity2")
    private List<PostInteractionEntity> postInteractionEntityList;
}

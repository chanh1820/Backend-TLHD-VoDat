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
@Table(name = "post_interaction_tbl")
public class PostInteractionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_interaction_id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "user_name")
    private String userName;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private PostEntity postEntity2;

}

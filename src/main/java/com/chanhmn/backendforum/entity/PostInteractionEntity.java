package com.chanhmn.backendforum.entity;

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

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private PostEntity postEntity;

}

package com.chanhmn.backendforum.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "topic_tbl")
public class TopicEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "topic_code")
    private String code;

    @Column(name = "topic_name")
    private String name;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "delete_flag")
    private boolean deleteFlag;
}

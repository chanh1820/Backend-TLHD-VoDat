package com.chanhmn.backendforum.repository;

import com.chanhmn.backendforum.entity.PostCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostCommentEntity, Integer> {

}
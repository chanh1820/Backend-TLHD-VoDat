package com.chanhmn.backendforum.repository;

import com.chanhmn.backendforum.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    @Query("SELECT p FROM PostEntity p WHERE topicCode = 'TP01'")
    List<PostEntity> getAll();
}
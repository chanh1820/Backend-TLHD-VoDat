package com.chanhmn.backendforum.repository;

import com.chanhmn.backendforum.core.sco.PostSCO;
import com.chanhmn.backendforum.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    @Query("SELECT p FROM PostEntity p WHERE deleteFlag = :deleteFlag")
    List<PostEntity> getAll(@Param("deleteFlag") boolean deleteFlag);
}
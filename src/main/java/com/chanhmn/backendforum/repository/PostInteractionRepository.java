package com.chanhmn.backendforum.repository;

import com.chanhmn.backendforum.entity.PostCommentEntity;
import com.chanhmn.backendforum.entity.PostEntity;
import com.chanhmn.backendforum.entity.PostInteractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostInteractionRepository extends JpaRepository<PostInteractionEntity, Integer> {
    @Query("SELECT p FROM PostInteractionEntity p WHERE " +
            "postId = :postId"+
            " AND userName = :userName"+
            " AND type = :type"+
            " AND deleteFlag = :deleteFlag")
    List<PostInteractionEntity> getInteractByUser(
            @Param("postEntity2") int postId,
            @Param("userName")String userName,
            @Param("type")String type,
            @Param("deleteFlag")boolean deleteFlag);
}
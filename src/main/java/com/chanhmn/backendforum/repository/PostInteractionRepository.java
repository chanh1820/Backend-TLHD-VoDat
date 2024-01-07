package com.chanhmn.backendforum.repository;

import com.chanhmn.backendforum.entity.PostCommentEntity;
import com.chanhmn.backendforum.entity.PostEntity;
import com.chanhmn.backendforum.entity.PostInteractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostInteractionRepository extends JpaRepository<PostInteractionEntity, Integer> {
    @Query("SELECT p FROM PostInteractionEntity p WHERE " +
            "postId = :postId"+
            "userName = :userName"+
            "type = :type"+
            "deleteFlag = :deleteFlag")
    List<PostInteractionEntity> getInteractByUser(int postId, String userName, String type, boolean deleteFlag);
}
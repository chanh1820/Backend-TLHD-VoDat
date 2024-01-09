package com.chanhmn.backendforum.repository;

import com.chanhmn.backendforum.entity.PostInteractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostInteractionRepository extends JpaRepository<PostInteractionEntity, Integer> {
    @Query("SELECT p FROM PostInteractionEntity p WHERE " +
            " p.postEntity2.id = :postId" +
            " AND p.userName = :userName " +
            " AND p.type = :type ")
    List<PostInteractionEntity> getInteractByUser(
            @Param("postId") int postId,
            @Param("userName") String userName,
            @Param("type") String type);

    @Query(value = "DELETE FROM post_interaction_tbl WHERE " +
            " post_id = :postId" +
            " AND user_name = :userName " +
            " AND type = :type ", nativeQuery = true)
    void deleteInteractByUser(
            @Param("postId") int postId,
            @Param("userName") String userName,
            @Param("type") String type);
}
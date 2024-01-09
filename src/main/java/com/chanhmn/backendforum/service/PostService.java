package com.chanhmn.backendforum.service;

import com.chanhmn.backendforum.core.dto.PostCommentDTO;
import com.chanhmn.backendforum.core.dto.PostDTO;
import com.chanhmn.backendforum.core.dto.PostInteractionDTO;
import com.chanhmn.backendforum.core.dto.ResponseDTO;
import com.chanhmn.backendforum.core.sco.PostSCO;
import com.chanhmn.backendforum.entity.PostCommentEntity;
import com.chanhmn.backendforum.entity.PostEntity;
import com.chanhmn.backendforum.entity.PostInteractionEntity;

import java.util.List;

public interface PostService {
    List<PostDTO> getAll(PostSCO postSCO);

    PostDTO getDetail(PostSCO postSCO);

    PostEntity insert(PostDTO postDTO);

    List<PostEntity> searchPost(PostSCO postSCO);

    PostCommentEntity insertComment(PostCommentDTO postCommentDTO);

    ResponseDTO<PostInteractionEntity> insertInteract(PostInteractionDTO postInteractionDTO);

    boolean validateInteractUser(PostInteractionDTO postInteractionDTO);

    void deletePostInteract(PostInteractionDTO postInteractionDTO);

    void deletePostInteractByUser(PostInteractionDTO postInteractionDTO);
}

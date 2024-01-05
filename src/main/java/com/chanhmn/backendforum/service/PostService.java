package com.chanhmn.backendforum.service;

import com.chanhmn.backendforum.core.dto.PostCommentDTO;
import com.chanhmn.backendforum.core.dto.PostDTO;
import com.chanhmn.backendforum.core.sco.PostSCO;
import com.chanhmn.backendforum.entity.PostCommentEntity;
import com.chanhmn.backendforum.entity.PostEntity;

import java.util.List;

public interface PostService {
    List<PostEntity> getAll(PostSCO postSCO);

    PostDTO getDetail(PostSCO postSCO);

    PostEntity insert(PostDTO postDTO);

    PostCommentEntity insertComment(PostCommentDTO postCommentDTO);
}

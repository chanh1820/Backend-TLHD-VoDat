package com.chanhmn.backendforum.service.impl;

import com.chanhmn.backendforum.core.dto.PostCommentDTO;
import com.chanhmn.backendforum.core.dto.PostDTO;
import com.chanhmn.backendforum.core.sco.PostSCO;
import com.chanhmn.backendforum.core.transformer.PostCommentMapper;
import com.chanhmn.backendforum.core.transformer.PostMapper;
import com.chanhmn.backendforum.entity.PostCommentEntity;
import com.chanhmn.backendforum.entity.PostEntity;
import com.chanhmn.backendforum.repository.PostCommentRepository;
import com.chanhmn.backendforum.repository.PostRepository;
import com.chanhmn.backendforum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostCommentRepository postCommentRepository;

    @Autowired
    PostMapper postMapper;

    @Autowired
    PostCommentMapper postCommentMapper;
    @Override
    public List<PostEntity> getAll(PostSCO postSCO) {
        return postRepository.getAll(postSCO.isDeleteFlag());
    }

    @Override
    public PostDTO getDetail(PostSCO postSCO) {
        PostDTO postDTO = new PostDTO();
        Optional<PostEntity> otp = postRepository.findById(postSCO.getId());
        if (otp.isPresent()) {
            postDTO = postMapper.entityToDTO(otp.get());
        }
        return null;
    }

    @Override
    public PostEntity insert(PostDTO postDTO) {
        return postRepository.save(postMapper.dtoToEntity(postDTO));
    }

    @Override
    public PostCommentEntity insertComment(PostCommentDTO postCommentDTO) {
        return postCommentRepository.save(postCommentMapper.dtoToEntity(postCommentDTO));
    }


}

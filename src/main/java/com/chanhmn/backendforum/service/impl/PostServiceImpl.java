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
import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

    @Autowired
    EntityManager entityManager;

    @Override
    public List<PostDTO> getAll(PostSCO postSCO) {
        return postMapper.entityListToDTOList(postRepository.getAll(postSCO.getDeleteFlag()));
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
    public List<PostEntity> searchPost(PostSCO postSCO) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PostEntity> criteriaQuery = criteriaBuilder.createQuery(PostEntity.class);

        Root<PostEntity> root = criteriaQuery.from(PostEntity.class);

        if(postSCO.getTopicCode()!=null){
            Predicate predicate = criteriaBuilder.equal(root.get("topicCode"), postSCO.getTopicCode());
            criteriaQuery.where(predicate);
        }

        if(postSCO.getDeleteFlag()!=null){
            Predicate predicate = criteriaBuilder.equal(root.get("deleteFlag"), postSCO.getDeleteFlag());
            criteriaQuery.where(predicate);
        }

        TypedQuery<PostEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
//        return null;
    }

    @Override
    public PostCommentEntity insertComment(PostCommentDTO postCommentDTO) {
        return postCommentRepository.save(postCommentMapper.dtoToEntity(postCommentDTO));
    }


}

package com.chanhmn.backendforum.service.impl;

import com.chanhmn.backendforum.core.dto.PostCommentDTO;
import com.chanhmn.backendforum.core.dto.PostDTO;
import com.chanhmn.backendforum.core.dto.PostInteractionDTO;
import com.chanhmn.backendforum.core.sco.PostSCO;
import com.chanhmn.backendforum.core.transformer.PostCommentMapper;
import com.chanhmn.backendforum.core.transformer.PostInteractionMapper;
import com.chanhmn.backendforum.core.transformer.PostMapper;
import com.chanhmn.backendforum.entity.PostCommentEntity;
import com.chanhmn.backendforum.entity.PostEntity;
import com.chanhmn.backendforum.entity.PostInteractionEntity;
import com.chanhmn.backendforum.repository.PostCommentRepository;
import com.chanhmn.backendforum.repository.PostInteractionRepository;
import com.chanhmn.backendforum.repository.PostRepository;
import com.chanhmn.backendforum.service.PostService;
import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
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
    PostInteractionRepository postInteractionRepository;

    @Autowired
    PostMapper postMapper;

    @Autowired
    PostCommentMapper postCommentMapper;

    @Autowired
    PostInteractionMapper postInteractionMapper;

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
        return postDTO;
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
//        root.fetch("postCommentEntityList");
//        root.fetch("postInteractionEntityList");
        if(postSCO.getTopicCode()!=null){
            Predicate predicate = criteriaBuilder.equal(root.get("topicCode"), postSCO.getTopicCode());
            criteriaQuery.where(predicate);
        }

        if(postSCO.getDeleteFlag()!=null){
            Predicate predicate = criteriaBuilder.equal(root.get("deleteFlag"), postSCO.getDeleteFlag());
            criteriaQuery.where(predicate);
        }

        TypedQuery<PostEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.setMaxResults(postSCO.getLimit()).getResultList();
    }

    @Override
    public PostCommentEntity insertComment(PostCommentDTO postCommentDTO) {
        return postCommentRepository.save(postCommentMapper.dtoToEntity(postCommentDTO));
    }

    @Override
    public PostInteractionEntity insertInteract(PostInteractionDTO postInteractionDTO) {
        if(validateInteractUser(postInteractionDTO)){
             return postInteractionRepository.save(postInteractionMapper.dtoToEntity(postInteractionDTO));
        }
        return null;
    }


    @Override
    public boolean validateInteractUser(PostInteractionDTO postInteractionDTO) {
        List<PostInteractionEntity> postInteractionEntityList = postInteractionRepository.getInteractByUser(
                postInteractionDTO.getPostId(),
                postInteractionDTO.getUserName(),
                postInteractionDTO.getType(),
                postInteractionDTO.isDeleteFlag()
        );
        return postInteractionEntityList.isEmpty();
    }


}

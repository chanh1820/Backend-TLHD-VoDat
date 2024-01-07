package com.chanhmn.backendforum.core.transformer;

import com.chanhmn.backendforum.core.dto.PostDTO;
import com.chanhmn.backendforum.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostMapper implements BaseMapper<PostEntity, PostDTO> {

    @Autowired
    PostCommentMapper postCommentMapper;

    @Autowired
    PostInteractionMapper postInteractionMapper;
    @Override
    public PostEntity dtoToEntity(PostDTO dto) {
        PostEntity postEntity = new PostEntity();
        if (dto.getId() != null) {
            postEntity.setId(dto.getId());
        }
        if (dto.getTopicCode() != null) {
            postEntity.setTopicCode(dto.getTopicCode());
        }
        if (dto.getTitle() != null) {
            postEntity.setTitle(dto.getTitle());
        }
        if (dto.getContent() != null) {
            postEntity.setContent(dto.getContent());
        }
        if (dto.getUserId() != null) {
            postEntity.setUserId(dto.getUserId());
        }
        if (dto.getAuthor() != null) {
            postEntity.setAuthor(dto.getAuthor());
        }
        if (dto.getCreateDate() != null) {
            postEntity.setCreateDate(dto.getCreateDate());
        }
        if (dto.getUpdateDate() != null) {
            postEntity.setUpdateDate(dto.getUpdateDate());
        }
        postEntity.setDeleteFlag(dto.isDeleteFlag());
        return postEntity;
    }

    @Override
    public PostDTO entityToDTO(PostEntity postEntity) {
        PostDTO postDTO = new PostDTO();
        if (postEntity.getId() != null) {
            postDTO.setId(postEntity.getId());
        }
        if (postEntity.getTopicCode() != null) {
            postDTO.setTopicCode(postEntity.getTopicCode());
        }
        if (postEntity.getTitle() != null) {
            postDTO.setTitle(postEntity.getTitle());
        }
        if (postEntity.getContent() != null) {
            postDTO.setContent(postEntity.getContent());
        }
        if (postEntity.getUserId() != null) {
            postDTO.setUserId(postEntity.getUserId());
        }
        if (postEntity.getAuthor() != null) {
            postDTO.setAuthor(postEntity.getAuthor());
        }
        if (postEntity.getCreateDate() != null) {
            postDTO.setCreateDate(postEntity.getCreateDate());
        }
        if (postEntity.getUpdateDate() != null) {
            postDTO.setUpdateDate(postEntity.getUpdateDate());
        }
        if (postEntity.getPostCommentEntityList() != null||postEntity.getPostCommentEntityList().size()!=0) {
            postDTO.setPostCommentDTOList(postCommentMapper.entityListToDTOList(postEntity.getPostCommentEntityList()));
        }
        if (postEntity.getPostInteractionEntityList() != null||postEntity.getPostInteractionEntityList().size()!=0) {
            postDTO.setPostInteractionDTOList(postInteractionMapper.entityListToDTOList(postEntity.getPostInteractionEntityList()));
        }
        postDTO.setCountComment(postEntity.getPostCommentEntityList().size());
        postDTO.setCountInteract(postEntity.getPostInteractionEntityList().size());

        postDTO.setDeleteFlag(postEntity.isDeleteFlag());
        return postDTO;
    }

    @Override
    public List<PostEntity> dtoListToEntityList(List<PostDTO> postDTOS) {
        List<PostEntity> postEntityList = new ArrayList<>();
        for (PostDTO item : postDTOS) {
            postEntityList.add(dtoToEntity(item));
        }
        return postEntityList;
    }

    @Override
    public List<PostDTO> entityListToDTOList(List<PostEntity> postEntities) {
        List<PostDTO> postDTOList = new ArrayList<>();
        for (PostEntity item : postEntities) {
            postDTOList.add(entityToDTO(item));
        }
        return postDTOList;
    }
}

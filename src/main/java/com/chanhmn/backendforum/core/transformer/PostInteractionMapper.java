package com.chanhmn.backendforum.core.transformer;

import com.chanhmn.backendforum.core.dto.PostCommentDTO;
import com.chanhmn.backendforum.core.dto.PostDTO;
import com.chanhmn.backendforum.core.dto.PostInteractionDTO;
import com.chanhmn.backendforum.entity.PostCommentEntity;
import com.chanhmn.backendforum.entity.PostEntity;
import com.chanhmn.backendforum.entity.PostInteractionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostInteractionMapper implements BaseMapper<PostInteractionEntity, PostInteractionDTO>{


    @Override
    public PostInteractionEntity dtoToEntity(PostInteractionDTO dto) {
        PostInteractionEntity entity = new PostInteractionEntity();
        if(dto.getId()!=null){
            entity.setId(dto.getId());
        }
        if(dto.getUserName()!=null){
            entity.setUserName(dto.getUserName());
        }
        if(dto.getType()!=null){
            entity.setType(dto.getType());
        }
        if(dto.getCreateDate()!=null){
            entity.setCreateDate(dto.getCreateDate());
        }
        if(dto.getPostEntity()!=null){
            entity.setPostEntity2(dto.getPostEntity());
        }
        return entity;
    }

    @Override
    public PostInteractionDTO entityToDTO(PostInteractionEntity entity) {
        PostInteractionDTO dto = new PostInteractionDTO();
        if(entity.getId()!=null){
            dto.setId(entity.getId());
        }
        if(entity.getUserName()!=null){
            dto.setUserName(entity.getUserName());
        }
        if(entity.getType()!=null){
            dto.setType(entity.getType());
        }
        if(entity.getCreateDate()!=null){
            dto.setCreateDate(entity.getCreateDate());
        }
        return dto;
    }

    @Override
    public List<PostInteractionEntity> dtoListToEntityList(List<PostInteractionDTO> dtoList) {
        List<PostInteractionEntity> entityList = new ArrayList<>();
        for (PostInteractionDTO item : dtoList) {
            entityList.add(dtoToEntity(item));
        }
        return entityList;
    }

    @Override
    public List<PostInteractionDTO> entityListToDTOList(List<PostInteractionEntity> entityList) {
        List<PostInteractionDTO> dtoList = new ArrayList<>();
        for (PostInteractionEntity item : entityList) {
            dtoList.add(entityToDTO(item));
        }
        return dtoList;    }
}

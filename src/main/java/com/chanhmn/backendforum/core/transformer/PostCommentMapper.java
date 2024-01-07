package com.chanhmn.backendforum.core.transformer;

import com.chanhmn.backendforum.core.dto.PostCommentDTO;
import com.chanhmn.backendforum.entity.PostCommentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostCommentMapper implements BaseMapper<PostCommentEntity, PostCommentDTO>{

    @Override
    public PostCommentEntity dtoToEntity(PostCommentDTO postCommentDTO) {
        PostCommentEntity postCommentEntity =  new PostCommentEntity();
        if(postCommentDTO.getId()!=null){
            postCommentEntity.setId(postCommentDTO.getId());
        }
        if(postCommentDTO.getUserName()!=null){
            postCommentEntity.setUserName(postCommentDTO.getUserName());
        }
        if(postCommentDTO.getDisplayName()!=null){
            postCommentEntity.setDisplayName(postCommentDTO.getDisplayName());
        }
        if(postCommentDTO.getContent()!=null){
            postCommentEntity.setContent(postCommentDTO.getContent());
        }
        if(postCommentDTO.getCreateDate()!=null){
            postCommentEntity.setCreateDate(postCommentDTO.getCreateDate());
        }
        postCommentEntity.setDeleteFlag(postCommentDTO.isDeleteFlag());

        return postCommentEntity;
    }

    @Override
    public PostCommentDTO entityToDTO(PostCommentEntity postCommentEntity) {
        PostCommentDTO postCommentDTO =  new PostCommentDTO();
        if(postCommentEntity.getId()!=null){
            postCommentDTO.setId(postCommentEntity.getId());
        }
        if(postCommentEntity.getUserName()!=null){
            postCommentDTO.setUserName(postCommentEntity.getUserName());
        }
        if(postCommentEntity.getDisplayName()!=null){
            postCommentDTO.setDisplayName(postCommentEntity.getDisplayName());
        }
        if(postCommentEntity.getContent()!=null){
            postCommentDTO.setContent(postCommentEntity.getContent());
        }
        if(postCommentEntity.getCreateDate()!=null){
            postCommentDTO.setCreateDate(postCommentEntity.getCreateDate());
        }
        postCommentDTO.setDeleteFlag(postCommentEntity.isDeleteFlag());

        return postCommentDTO;
    }

    @Override
    public List<PostCommentEntity> dtoListToEntityList(List<PostCommentDTO> postCommentDTOS) {
        List<PostCommentEntity> postCommentEntityList = new ArrayList<>();
        for (PostCommentDTO item : postCommentDTOS) {
            postCommentEntityList.add(dtoToEntity(item));
        }
        return postCommentEntityList;
    }

    @Override
    public List<PostCommentDTO> entityListToDTOList(List<PostCommentEntity> postCommentEntities) {
        List<PostCommentDTO> postCommentDTOList = new ArrayList<>();
        for (PostCommentEntity item : postCommentEntities) {
            postCommentDTOList.add(entityToDTO(item));
        }
        return postCommentDTOList;        }
}

package com.chanhmn.backendforum.controller;

import com.chanhmn.backendforum.core.constant.DBConstant;
import com.chanhmn.backendforum.core.dto.PostCommentDTO;
import com.chanhmn.backendforum.core.dto.PostDTO;
import com.chanhmn.backendforum.core.dto.PostInteractionDTO;
import com.chanhmn.backendforum.core.dto.ResponseDTO;
import com.chanhmn.backendforum.core.sco.PostSCO;
import com.chanhmn.backendforum.core.transformer.PostMapper;
import com.chanhmn.backendforum.core.util.ObjectMapperUtils;
import com.chanhmn.backendforum.entity.PostCommentEntity;
import com.chanhmn.backendforum.entity.PostEntity;
import com.chanhmn.backendforum.entity.PostInteractionEntity;
import com.chanhmn.backendforum.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostMapper postMapper;


    @PostMapping("/insert")
    public ResponseDTO<PostEntity> insertPost(@RequestBody PostDTO postDTO) {
        ResponseDTO<PostEntity> responseDTO = new ResponseDTO<>();
        PostEntity postEntity = postService.insert(postDTO);
        responseDTO.setData(postEntity);
        return responseDTO;
    }

    @PostMapping("/search_post")
    public ResponseDTO<List<PostDTO>> getPostList(@RequestBody PostSCO postSCO) {
        log.info("Start searchPostList: {}", ObjectMapperUtils.dtoToString(postSCO));
        ResponseDTO<List<PostDTO>> responseDTO = new ResponseDTO<>();
        List<PostEntity> postEntityList = postService.searchPost(postSCO);
        List<PostDTO> postDTOList = postMapper.entityListToDTOList(postEntityList);
        responseDTO.setData(postDTOList);
        log.info("End searchPostList");
        return responseDTO;
    }

    @PostMapping("/get")
    public ResponseDTO<PostDTO> getPostDetail(@RequestBody PostSCO postSCO) {
        log.info("Start getPostDetail: {}", ObjectMapperUtils.dtoToString(postSCO));
        PostDTO postDTO = postService.getDetail(postSCO);
        ResponseDTO<PostDTO> responseDTO = new ResponseDTO<>();
        if (postDTO == null) {
            responseDTO.setStatusCode(DBConstant.STATUS_CODE_ERROR);
            responseDTO.setMessage("Entity not found");
            return responseDTO;
        }
        responseDTO.setData(postDTO);
        log.info("End getPostDetail");

        return responseDTO;
    }

    @PostMapping("/comment/insert")
    public ResponseDTO<PostCommentEntity> insertPostComment(@RequestBody PostCommentDTO postCommentDTO) {
        log.info("Start insertPostComment: {}", ObjectMapperUtils.dtoToString(postCommentDTO));
        ResponseDTO<PostCommentEntity> responseDTO = new ResponseDTO<>();
        PostCommentEntity postCommentEntity = postService.insertComment(postCommentDTO);
        log.info("End insertPostComment");
        responseDTO.setData(postCommentEntity);
        return responseDTO;
    }

    @PostMapping("/interact/insert")
    public ResponseDTO<PostInteractionEntity> insertPostInteract(@RequestBody PostInteractionDTO postInteractionDTO) {
        log.info("Start insertPostInteract: {}", ObjectMapperUtils.dtoToString(postInteractionDTO));
        ResponseDTO<PostInteractionEntity> responseDTO = postService.insertInteract(postInteractionDTO);
        log.info("End insertPostInteract");
        return responseDTO;
    }

    @PostMapping("/interact/delete")
    public ResponseDTO<PostInteractionEntity> deletePostInteract(@RequestBody PostInteractionDTO postInteractionDTO) {
        log.info("Start deletePostInteract: {}", ObjectMapperUtils.dtoToString(postInteractionDTO));
        ResponseDTO<PostInteractionEntity> responseDTO = new ResponseDTO<>();
        postService.deletePostInteractByUser(postInteractionDTO);
        log.info("End deletePostInteract");
        return responseDTO;
    }

}

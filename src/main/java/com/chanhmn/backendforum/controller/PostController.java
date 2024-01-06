package com.chanhmn.backendforum.controller;

import com.chanhmn.backendforum.core.dto.PostCommentDTO;
import com.chanhmn.backendforum.core.dto.PostDTO;
import com.chanhmn.backendforum.core.dto.ResponseDTO;
import com.chanhmn.backendforum.core.sco.PostSCO;
import com.chanhmn.backendforum.core.transformer.PostMapper;
import com.chanhmn.backendforum.core.util.ObjectMapperUtils;
import com.chanhmn.backendforum.entity.PostCommentEntity;
import com.chanhmn.backendforum.entity.PostEntity;
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
    public List<PostDTO> getPostList(@RequestBody PostSCO postSCO) {
        log.info("Start searchPostList: {}", ObjectMapperUtils.dtoToString(postSCO));
        List<PostEntity> postEntityList = postService.searchPost(postSCO);
        List<PostDTO> postDTOList = postMapper.entityListToDTOList(postEntityList);
        log.info("End searchPostList: {}", ObjectMapperUtils.dtoToString(postDTOList));

        return postDTOList;
    }

    @PostMapping("/get")
    public PostDTO getPostDetail(@RequestBody PostSCO postSCO) {
        List<PostDTO> postEntityList = postService.getAll(postSCO);
        return null;
    }

    @PostMapping("/comment/insert")
    public ResponseDTO<PostCommentEntity> insertPostComment(@RequestBody PostCommentDTO postCommentDTO) {
        ResponseDTO<PostCommentEntity> responseDTO = new ResponseDTO<>();
        PostCommentEntity postCommentEntity = postService.insertComment(postCommentDTO);
        responseDTO.setData(postCommentEntity);
        return responseDTO;
    }

}

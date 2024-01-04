package com.chanhmn.backendforum.controller;

import com.chanhmn.backendforum.core.sco.TopicSCO;
import com.chanhmn.backendforum.entity.PostEntity;
import com.chanhmn.backendforum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;
    @PostMapping("/find_all")
    public List<PostEntity> createProduct(@RequestBody TopicSCO topicSCO) {
        List<PostEntity> postEntityList = postService.getAll();
        return postEntityList;
    }
}

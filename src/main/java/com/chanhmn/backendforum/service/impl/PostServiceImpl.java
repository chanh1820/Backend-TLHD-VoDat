package com.chanhmn.backendforum.service.impl;

import com.chanhmn.backendforum.entity.PostEntity;
import com.chanhmn.backendforum.repository.PostRepository;
import com.chanhmn.backendforum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<PostEntity> getAll() {
        return postRepository.getAll();
    }
}

package com.chanhmn.backendforum.service.impl;

import com.chanhmn.backendforum.entity.TopicEntity;
import com.chanhmn.backendforum.repository.TopicRepository;
import com.chanhmn.backendforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Override
    public List<TopicEntity> findAll() {
        return topicRepository.findAll();
    }
}

package com.chanhmn.backendforum.service;

import com.chanhmn.backendforum.entity.TopicEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TopicService {
    List<TopicEntity> findAll();

}

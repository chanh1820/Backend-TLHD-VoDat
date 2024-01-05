package com.chanhmn.backendforum.controller;

import com.chanhmn.backendforum.core.sco.TopicSCO;
import com.chanhmn.backendforum.entity.TopicEntity;
import com.chanhmn.backendforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    TopicService topicService;
    @PostMapping("/get_all")
    public List<TopicEntity> createProduct(@RequestBody TopicSCO topicSCO) {
        List<TopicEntity> topicEntityList = topicService.findAll();
        return topicEntityList;
    }
}

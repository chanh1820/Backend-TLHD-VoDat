package com.chanhmn.backendforum.repository;

import com.chanhmn.backendforum.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {

}
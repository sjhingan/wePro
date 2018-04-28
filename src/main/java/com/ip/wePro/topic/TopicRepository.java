package com.ip.wePro.topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long>{
    Topic findById(int id);
    boolean deleteById(int id);
}

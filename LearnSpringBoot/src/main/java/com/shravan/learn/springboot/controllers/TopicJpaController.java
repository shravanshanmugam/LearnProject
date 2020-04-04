package com.shravan.learn.springboot.controllers;

import com.shravan.learn.springboot.model.Topic;
import com.shravan.learn.springboot.service.TopicJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/topics")
public class TopicJpaController {

    @Autowired
    private TopicJpaService topicJpaService;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicJpaService.getAllTopics();
    }

    @GetMapping("/{topicId}")
    public Topic getTopic(@PathVariable String topicId) {
        return topicJpaService.getTopic(topicId);
    }

    @PostMapping
    public void addTopic(@RequestBody Topic topic) {
        topicJpaService.addTopic(topic);
    }

    @PutMapping("/{topicId}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String topicId) {
        topicJpaService.updateTopic(topic, topicId);
    }

    @DeleteMapping("/{topicId}")
    public void deleteTopic(@PathVariable String topicId) {
        topicJpaService.deleteTopic(topicId);
    }
}

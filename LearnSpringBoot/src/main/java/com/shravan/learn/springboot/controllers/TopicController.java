package com.shravan.learn.springboot.controllers;

import com.shravan.learn.springboot.model.Topic;
import com.shravan.learn.springboot.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{topicId}")
    public Topic getTopic(@PathVariable String topicId) {
        return topicService.getTopic(topicId);
    }

    @PostMapping
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @PutMapping("/{topicId}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String topicId) {
        topicService.updateTopic(topic, topicId);
    }

    @DeleteMapping("/{topicId}")
    public void deleteTopic(@PathVariable String topicId) {
        topicService.deleteTopic(topicId);
    }
}

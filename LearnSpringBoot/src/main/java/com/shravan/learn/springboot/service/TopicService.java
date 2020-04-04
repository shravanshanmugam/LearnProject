package com.shravan.learn.springboot.service;

import com.shravan.learn.springboot.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description"))
    );

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String topicId) {
        final Optional<Topic> optionalTopic = topics.stream().filter(t -> t.getTopicId().equalsIgnoreCase(topicId)).findFirst();
        return optionalTopic.orElseGet(Topic::new);
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String topicId) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getTopicId().equalsIgnoreCase(topicId)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String topicId) {
        topics.removeIf(t -> t.getTopicId().equalsIgnoreCase(topicId));
    }
}

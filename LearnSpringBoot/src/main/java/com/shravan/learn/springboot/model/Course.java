package com.shravan.learn.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Course {

    @Id
    private String courseId;
    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

    public Course(String courseId, String name, String description, String topicId) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
    }
}

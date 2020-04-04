package com.shravan.learn.springboot.repository;

import com.shravan.learn.springboot.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

    public List<Course> findByName(String name);

    public List<Course> findByTopicTopicId(String topicId);
}

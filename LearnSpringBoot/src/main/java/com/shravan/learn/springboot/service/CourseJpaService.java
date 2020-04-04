package com.shravan.learn.springboot.service;

import com.shravan.learn.springboot.model.Course;
import com.shravan.learn.springboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseJpaService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String courseId) {
        return courseRepository.findById(courseId).get();
    }

    public List<Course> getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String courseId) {
        courseRepository.deleteById(courseId);
    }
}

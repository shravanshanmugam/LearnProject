package com.shravan.learn.springboot.controllers;

import com.shravan.learn.springboot.model.Course;
import com.shravan.learn.springboot.model.Topic;
import com.shravan.learn.springboot.service.CourseJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/topics")
public class CourseJpaController {

    @Autowired
    private CourseJpaService courseJpaService;

    @GetMapping("/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseJpaService.getAllCourses(topicId);
    }

    @GetMapping("/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return courseJpaService.getCourse(courseId);
    }

    @GetMapping("/{topicId}/courses/{courseId}/name/{name}")
    public List<Course> getCourseByName(@PathVariable String name) {
        return courseJpaService.getCourseByName(name);
    }

    @PostMapping("/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseJpaService.addCourse(course);
    }

    @PutMapping("/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseJpaService.updateCourse(course);
    }

    @DeleteMapping("/{topicId}/courses/{courseId}")
    public void deleteTopic(@PathVariable String courseId) {
        courseJpaService.deleteCourse(courseId);
    }
}

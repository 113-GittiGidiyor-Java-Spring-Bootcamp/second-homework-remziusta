package com.work.spring.controller;

import com.work.spring.model.Course;
import com.work.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Course>> getAllCourse(){
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> findCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseService.findById(id),HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course c = new Course(course.getCourseName(),course.getCourseCredit());
        courseService.create(c);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        Course c = courseService.findById(course.getId());
        if(course.getCourseName() != null){
            c.setCourseName(course.getCourseName());
        }
        if(course.getCourseCredit() != null){
            c.setCourseCredit(course.getCourseCredit());
        }
        return new ResponseEntity<>(courseService.update(c),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        courseService.delete(id);
        return new ResponseEntity<>("info : Deleted course", HttpStatus.OK);
    }

}

package com.work.spring.service;

import com.work.spring.dao.CourseDao;
import com.work.spring.dao.ICrud;
import com.work.spring.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements IServices<Course>{

    CourseDao courseRepository;

    @Autowired
    public void setCourseRepository(CourseDao courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public Course findById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void create(Course item) {
        courseRepository.create(item);
    }

    @Override
    public Course update(Course item) {
        return courseRepository.update(item);
    }

    @Override
    public void delete(long id) {
        courseRepository.delete(id);
    }
}

package com.work.spring.controller;

import com.work.spring.model.Course;
import com.work.spring.model.Instructor;
import com.work.spring.model.PermanentInstructor;
import com.work.spring.model.VisitorInstructor;
import com.work.spring.service.CourseService;
import com.work.spring.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    InstructorService instructorService;

    CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    //That's method get all intructors
    @GetMapping("")
    public ResponseEntity<List<Instructor>> getAllInstructor(){
        return new ResponseEntity<>(instructorService.getAll(), HttpStatus.OK);
    }

    //That's method get a instructor
    @GetMapping(value = "/{id}")
    public ResponseEntity<Instructor> findInstructor(@PathVariable Long id){
        return new ResponseEntity<>(instructorService.findById(id),HttpStatus.OK);
    }

    //That's method add a instructor
    @PostMapping("")
    public ResponseEntity<List<Instructor>> addInstructor(@RequestBody Instructor instructor){
         if(instructor.getType()){
              instructorService.create(new PermanentInstructor(instructor.getName(),instructor.getAddress(),instructor.getPhoneNumber(),instructor.getSalary()));
          }else{
              instructorService.create(new VisitorInstructor(instructor.getName(),instructor.getAddress(),instructor.getPhoneNumber(),instructor.getSalary()));
          }

        return new ResponseEntity<>(instructorService.getAll(),HttpStatus.OK);
    }

    //That's method update a instructor
    @PutMapping(value = "")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor){
        Instructor i = instructorService.findById(instructor.getId());
        if(instructor.getName() != null){
            i.setName(instructor.getName());
        }
        if (instructor.getAddress() != null){
            i.setAddress(instructor.getAddress());
        }
        if(instructor.getPhoneNumber() != null){
            i.setPhoneNumber(instructor.getPhoneNumber());
        }
        if(instructor.getSalary() != null){
            i.setSalary(instructor.getSalary());
        }
        return new ResponseEntity<>(instructorService.update(i),HttpStatus.OK);
    }

    //That's method delete a instructor
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long id){
        instructorService.delete(id);
        return new ResponseEntity<>("info : Deleted instructor",HttpStatus.OK);
    }

    //That's method add a course in instructor and a instructor in course
    @PostMapping(value = "/{instructorId}/{courseId}")
    public ResponseEntity<Instructor> addCourse(@PathVariable(value = "instructorId") Long instructorId,
                                                @PathVariable(value = "courseId") Long courseId)
    {
        Instructor i = instructorService.findById(instructorId);
        Course c = courseService.findById(courseId);
        i.getCourses().add(c);
        c.setInstructor(i);
        courseService.update(c);
        instructorService.update(i);
        return new ResponseEntity<>(instructorService.findById(instructorId), HttpStatus.OK);
    }
}

package com.work.spring.controller;

import com.work.spring.model.Student;
import com.work.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    //That's method get all students
    @GetMapping(value = "")
    public ResponseEntity<List<Student>> getAllStudent(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    //That's method get a student
    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    //That's method add a student
    @PostMapping(value = "")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student s = new Student(student.getName(),student.getBirthDate(),student.getAge());
        studentService.create(s);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

    //That's method update a student
    @PutMapping(value = "")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.update(student),HttpStatus.OK);
    }

    //That's method delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return new ResponseEntity<>("Info : Deleted student", HttpStatus.OK);
    }

}

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

    @GetMapping(value = "")
    public ResponseEntity<List<Student>> getAllStudent(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student s = new Student(student.getName(),student.getBirthDate(),student.getAge());
        studentService.create(s);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student s = studentService.findById(student.getId());
        if(student.getName() != null){
            s.setName(student.getName());
        }
        if(student.getBirthDate() != null){
            s.setBirthDate(student.getBirthDate());
        }
        if(student.getAge() != null){
            s.setAge(student.getAge());
        }
        return new ResponseEntity<>(studentService.update(s),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return new ResponseEntity<>("Info : Deleted student", HttpStatus.OK);
    }

}

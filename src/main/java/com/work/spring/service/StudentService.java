package com.work.spring.service;

import com.work.spring.dao.ICrud;
import com.work.spring.dao.StudentDao;
import com.work.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IServices<Student> {

    StudentDao studentRepository;

    @Autowired
    public void setStudentRepository(StudentDao studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void create(Student item) {
        studentRepository.create(item);
    }

    @Override
    public Student update(Student item) {
        return studentRepository.update(item);
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(id);
    }
}

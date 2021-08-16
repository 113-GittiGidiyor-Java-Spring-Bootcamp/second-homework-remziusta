package com.work.spring.service;

import com.work.spring.dao.InstructorDao;
import com.work.spring.daoimp.InstructorDaoImp;
import com.work.spring.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService implements IServices<Instructor> {

    InstructorDao instructorRepository;

    @Autowired
    public void setInstructorRepository(InstructorDao instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAll() {
        return instructorRepository.getAll();
    }

    @Override
    public Instructor findById(long id) {
        return instructorRepository.findById(id);
    }

    @Override
    public void create(Instructor item) {
        instructorRepository.create(item);
    }

    @Override
    public Instructor update(Instructor item) {
        return instructorRepository.update(item);
    }

    @Override
    public void delete(long id) {
        instructorRepository.delete(id);
    }
}

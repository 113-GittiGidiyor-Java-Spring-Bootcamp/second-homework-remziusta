package com.work.spring.daoimp;

import com.work.spring.dao.StudentDao;
import com.work.spring.exception.NotFoundStudentException;
import com.work.spring.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAll() {
        return entityManager.createQuery("from Student",Student.class).getResultList();
    }

    @Override
    public Student findById(long id) throws NotFoundStudentException {
        return entityManager.find(Student.class,id);
    }

    @Transactional
    @Override
    public void create(Student item) {
         entityManager.persist(item);
    }

    @Transactional
    @Override
    public Student update(Student item) {
        return entityManager.merge(item);
    }

    @Transactional
    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.getReference(Student.class,id));
    }
}

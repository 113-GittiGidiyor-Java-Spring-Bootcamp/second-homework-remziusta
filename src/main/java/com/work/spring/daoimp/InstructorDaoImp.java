package com.work.spring.daoimp;

import com.work.spring.dao.InstructorDao;
import com.work.spring.model.Instructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class InstructorDaoImp implements InstructorDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Instructor> getAll() {
        return entityManager.createQuery("from Instructor", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(long id) throws RuntimeException {
        return entityManager.find(Instructor.class,id);
    }

    @Transactional
    @Override
    public void create(Instructor item) {
        entityManager.persist(item);
    }

    @Transactional
    @Override
    public Instructor update(Instructor item) {
        return entityManager.merge(item);
    }

    @Transactional
    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.getReference(Instructor.class,id));
    }
}

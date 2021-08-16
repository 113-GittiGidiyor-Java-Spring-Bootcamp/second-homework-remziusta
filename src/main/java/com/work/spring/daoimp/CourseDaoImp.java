package com.work.spring.daoimp;

import com.work.spring.dao.CourseDao;
import com.work.spring.exception.NotFoundCourseException;
import com.work.spring.model.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDaoImp implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> getAll() {
        return entityManager.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(long id) throws NotFoundCourseException {
        return entityManager.find(Course.class,id);
    }

    @Transactional
    @Override
    public void create(Course item) {
        entityManager.persist(item);
    }

    @Transactional
    @Override
    public Course update(Course item) {
        return entityManager.merge(item);
    }

    @Transactional
    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.getReference(Course.class,id));
    }
}

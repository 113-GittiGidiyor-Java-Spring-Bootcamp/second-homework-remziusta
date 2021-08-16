package com.work.spring.dao;

import java.util.List;

public interface ICrud<T> {
    List<T> getAll();

    T findById(long id) throws RuntimeException;

    void create(T item);

    T update(T item);

    void delete(long id);
}

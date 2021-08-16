package com.work.spring.service;

import java.util.List;

public interface IServices<T> {

    List<T> getAll();

    T findById(long id);

    void create(T item);

    T update(T item);

    void delete(long id);
}

package com.edu.dao;

import java.util.List;

public interface BaseDao<T> {
    boolean insert(T t);

    boolean delete(int id);

    boolean update(T t);

    T findById(int id);

    List<T> findAll();
}

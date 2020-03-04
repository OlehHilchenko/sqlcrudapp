package com.olehhilchenko.repository;

public interface GenericRepository<T, I> {

    void insert (T t);

    void update (T t);

    T select (I i);

    void delete (T t);

}

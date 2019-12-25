package Homework10.common.business.repo;

import java.util.List;

public interface CommonRepo<T> {

    boolean deleteById(long id);

    void add(T t);

    void update(T t);

    List<T> getAll();

    T getById(long id);

}
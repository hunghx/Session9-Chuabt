package service;

import java.util.List;

public interface IGeneric <T,E>{
    List<T> findAll();
    T findById(E id);
    void delete(E id);
    void add(T t);
    void update(T t);
    Long getNewId();

}

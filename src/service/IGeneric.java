package service;

public interface IGeneric <T,E>{
    T[] findAll();
    T findById(E id);
    void delete(E id);
    void add(T t);
    void update(T t);
    int findIndexById(E id);
    Long getNewId();

}

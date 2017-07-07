package com.exercise.dao.contract;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
public interface IDao<T> {

    public  T create(T model);
    public  T update(T model);
    public  T get(int id);
    public  void delete(T model);
    public  void delete(int id);

}

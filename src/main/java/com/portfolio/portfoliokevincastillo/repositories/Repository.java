package com.portfolio.portfoliokevincastillo.repositories;

import java.util.*;

public interface Repository<T> {
    void save(T t);

    T findById(int id);

    List<T> findAll();

    void delete(int id);

}

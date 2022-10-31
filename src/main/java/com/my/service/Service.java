package com.my.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface Service<T, ID> {
    List<T> findAll();
    List<T> findAll(Sort sort);
    Page<T> findAll(Pageable pageable);
    Page<T> findAll(Pageable pageable, String sortBy);
    Page<T> search(String searchValue, String sortBy, Pageable pageable);

    Optional<T> findById(ID id);

    void save(T entity);

    void delete(T entity);
    void deleteById(ID id);
    void deleteAll();
}

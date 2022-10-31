package com.my.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class AbstractService<T, ID> implements Service<T, ID> {
    protected MongoRepository<T, ID> mongoRepository;
    protected JpaRepository<T, ID> jpaRepository;

    protected abstract Page<T> getSearch(String searchValue, Pageable pageable);

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return jpaRepository.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Override
    public Page<T> findAll(Pageable pageable, String sortBy) {
        if (sortBy == null) {
            return findAll(pageable);
        }

        pageable = getPageable(pageable, sortBy);

        return findAll(pageable);
    }

    @Override
    public Page<T> search(String searchValue, String sortBy, Pageable pageable) {
        if (sortBy == null) {
            return getSearch(searchValue, pageable);
        }

        pageable = getPageable(pageable, sortBy);

        return getSearch(searchValue, pageable);
    }

    protected Pageable getPageable(Pageable pageable, String sortBy) {
        char order = sortBy.charAt(0);
        sortBy = sortBy.replaceFirst(order + "_", "");
        if (order == 'a') {
            pageable = PageRequest.of(pageable.getPageNumber(),
                    pageable.getPageSize(), Sort.by(Sort.Direction.ASC, sortBy));
        }

        if (order == 'd') {
            pageable = PageRequest.of(pageable.getPageNumber(),
                    pageable.getPageSize(), Sort.by(Sort.Direction.DESC, sortBy));
        }
        return pageable;
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public void save(T entity) {
        mongoRepository.save(entity);
        jpaRepository.save(entity);
    }

    @Override
    public void delete(T entity) {
        mongoRepository.delete(entity);
        jpaRepository.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        mongoRepository.deleteById(id);
        jpaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        mongoRepository.deleteAll();
        jpaRepository.deleteAll();
    }
}

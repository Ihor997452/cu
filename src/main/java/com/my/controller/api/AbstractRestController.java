package com.my.controller.api;

import com.my.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public abstract class AbstractRestController<T, ID> {
    protected Service<T, ID> service;

    @GetMapping("/search")
    public Page<T> search(@RequestParam String searchValue,
                                   @RequestParam(required = false) String sortBy,
                                   @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC)
                                   Pageable pageable) {
        return service.search(searchValue, sortBy, pageable);
    }

    @GetMapping
    public Page<T> findAll(@RequestParam(required = false) String sortBy,
                           @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC)
                           Pageable pageable) {
        return service.findAll(pageable, sortBy);
    }

    @GetMapping("/{id}")
    public Optional<T> findById(@PathVariable ID id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody T entity) {
        service.save(entity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ID id) {
        service.deleteById(id);
    }

    @DeleteMapping("/clear")
    public void clear() {
        service.deleteAll();
    }
}

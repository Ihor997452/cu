package com.my.repository.basic;

import com.my.model.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RequestRepository {
    Page<Request> findByDescriptionContainingIgnoreCase(String desc, Pageable pageable);
}

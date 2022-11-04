package com.my.repository.basic;

import com.my.model.MobileOperator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MobileOperatorRepository {
    Page<MobileOperator> findByNameContainingIgnoreCaseOrHotlineContainingIgnoreCaseOrEmailContainingIgnoreCaseOrWebsiteContainingIgnoreCase(String name, String hotline, String email, String website, Pageable pageable);
}

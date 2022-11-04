package com.my.repository.basic;

import com.my.model.SpecialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SpecialServiceRepository {
    Page<SpecialService> findByNameContainingIgnoreCaseOrPhoneNumberContainingIgnoreCase(String name, String phone, Pageable pageable);
}

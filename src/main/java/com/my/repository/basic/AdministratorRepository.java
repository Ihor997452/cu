package com.my.repository.basic;

import com.my.model.Administrator;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AdministratorRepository {
    Administrator findByEmail(String email);
}

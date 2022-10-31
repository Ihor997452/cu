package com.my.repository.jpa;

import com.my.model.Administrator;
import com.my.repository.basic.AdministratorRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAdministratorRepository extends JpaRepository<Administrator, Integer>, AdministratorRepository {
}

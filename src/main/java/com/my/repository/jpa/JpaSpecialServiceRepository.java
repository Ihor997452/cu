package com.my.repository.jpa;

import com.my.model.SpecialService;
import com.my.repository.basic.SpecialServiceRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSpecialServiceRepository extends JpaRepository<SpecialService, Integer>, SpecialServiceRepository {
}

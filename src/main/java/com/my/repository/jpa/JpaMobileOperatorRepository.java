package com.my.repository.jpa;

import com.my.model.MobileOperator;
import com.my.repository.basic.MobileOperatorRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMobileOperatorRepository extends JpaRepository<MobileOperator, Integer>, MobileOperatorRepository {
}

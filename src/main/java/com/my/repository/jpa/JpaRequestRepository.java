package com.my.repository.jpa;

import com.my.model.Request;
import com.my.repository.basic.RequestRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRequestRepository extends JpaRepository<Request, String>, RequestRepository {
}

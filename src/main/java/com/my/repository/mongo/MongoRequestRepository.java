package com.my.repository.mongo;

import com.my.model.Request;
import com.my.repository.basic.RequestRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRequestRepository extends MongoRepository<Request, Integer>, RequestRepository {
}

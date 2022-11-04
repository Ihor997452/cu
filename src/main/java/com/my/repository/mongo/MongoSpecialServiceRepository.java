package com.my.repository.mongo;

import com.my.model.SpecialService;
import com.my.repository.basic.SpecialServiceRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoSpecialServiceRepository extends MongoRepository<SpecialService, String>, SpecialServiceRepository {
}

package com.my.repository.mongo;

import com.my.model.MobileOperator;
import com.my.repository.basic.MobileOperatorRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoMobileOperatorRepository extends MongoRepository<MobileOperator, Integer>, MobileOperatorRepository {
}

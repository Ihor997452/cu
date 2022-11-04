package com.my.repository.mongo;

import com.my.model.Administrator;
import com.my.repository.basic.AdministratorRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAdministratorRepository extends MongoRepository<Administrator, String>, AdministratorRepository {
}

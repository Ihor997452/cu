package com.my.service.administrator;

import com.my.model.Administrator;
import com.my.repository.mongo.MongoAdministratorRepository;
import com.my.repository.jpa.JpaAdministratorRepository;
import com.my.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl extends AbstractService<Administrator, String> implements AdministratorService {
    public AdministratorServiceImpl(MongoAdministratorRepository mongoUserRepository,
                                    JpaAdministratorRepository jpaUserRepository) {
        this.mongoRepository = mongoUserRepository;
        this.jpaRepository = jpaUserRepository;
    }

    @Override
    protected Page<Administrator> getSearch(String searchValue, Pageable pageable) {
        throw new UnsupportedOperationException();
    }
}

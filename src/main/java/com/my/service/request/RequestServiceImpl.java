package com.my.service.request;

import com.my.model.Request;
import com.my.repository.jpa.JpaRequestRepository;
import com.my.repository.mongo.MongoRequestRepository;
import com.my.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl extends AbstractService<Request, Integer> implements RequestService {
    public RequestServiceImpl(JpaRequestRepository jpaRequestRepository,
                              MongoRequestRepository mongoRequestRepository) {
        this.jpaRepository = jpaRequestRepository;
        this.mongoRepository = mongoRequestRepository;
    }

    @Override
    protected Page<Request> getSearch(String searchValue, Pageable pageable) {
        return null;
    }
}

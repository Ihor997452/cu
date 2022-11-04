package com.my.service.specialService;

import com.my.model.SpecialService;
import com.my.repository.basic.SpecialServiceRepository;
import com.my.repository.jpa.JpaSpecialServiceRepository;
import com.my.repository.mongo.MongoSpecialServiceRepository;
import com.my.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SpecialServiceServiceImpl extends AbstractService<SpecialService, String> implements SpecialServiceService {
    public SpecialServiceServiceImpl(JpaSpecialServiceRepository jpaSpecialServiceRepository,
                                     MongoSpecialServiceRepository mongoSpecialServiceRepository) {
        this.jpaRepository = jpaSpecialServiceRepository;
        this.mongoRepository = mongoSpecialServiceRepository;
    }

    @Override
    protected Page<SpecialService> getSearch(String searchValue, Pageable pageable) {
        return ((SpecialServiceRepository) jpaRepository).findByNameContainingIgnoreCaseOrPhoneNumberContainingIgnoreCase(
                searchValue,
                searchValue,
                pageable
        );
    }
}

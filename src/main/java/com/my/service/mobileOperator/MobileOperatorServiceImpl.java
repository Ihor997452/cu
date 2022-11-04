package com.my.service.mobileOperator;

import com.my.model.MobileOperator;
import com.my.repository.basic.MobileOperatorRepository;
import com.my.repository.jpa.JpaMobileOperatorRepository;
import com.my.repository.mongo.MongoMobileOperatorRepository;
import com.my.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MobileOperatorServiceImpl extends AbstractService<MobileOperator, String> implements MobileOperatorService {
    @Autowired
    public MobileOperatorServiceImpl(MongoMobileOperatorRepository mongoMobileOperatorRepository,
                                     JpaMobileOperatorRepository jpaMobileOperatorRepository) {
        this.mongoRepository = mongoMobileOperatorRepository;
        this.jpaRepository = jpaMobileOperatorRepository;
    }

    @Override
    protected Page<MobileOperator> getSearch(String searchValue, Pageable pageable) {
        return ((MobileOperatorRepository) jpaRepository).findByNameContainingIgnoreCaseOrHotlineContainingIgnoreCaseOrEmailContainingIgnoreCaseOrWebsiteContainingIgnoreCase(
                searchValue,
                searchValue,
                searchValue,
                searchValue,
                pageable
        );
    }
}

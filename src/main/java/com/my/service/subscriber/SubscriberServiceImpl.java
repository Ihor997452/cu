package com.my.service.subscriber;

import com.my.model.Subscriber;
import com.my.repository.basic.SubscriberRepository;
import com.my.repository.jpa.JpaSubscriberRepository;
import com.my.repository.mongo.MongoSubscriberRepository;
import com.my.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl extends AbstractService<Subscriber, String> implements SubscriberService {
    public SubscriberServiceImpl(JpaSubscriberRepository jpaSubscriberRepository,
                                 MongoSubscriberRepository mongoSubscriberRepository) {
        this.jpaRepository = jpaSubscriberRepository;
        this.mongoRepository = mongoSubscriberRepository;
    }

    @Override
    protected Page<Subscriber> getSearch(String searchValue, Pageable pageable) {
        return ((SubscriberRepository) jpaRepository).findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrPatronymicContainingIgnoreCaseOrCityContainingIgnoreCaseOrStreetContainingIgnoreCaseOrPhoneNumberContainingIgnoreCase(
                        searchValue,
                        searchValue,
                        searchValue,
                        searchValue,
                        searchValue,
                        searchValue,
                        pageable
                );
    }
}

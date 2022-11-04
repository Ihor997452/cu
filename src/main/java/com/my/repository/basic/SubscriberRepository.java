package com.my.repository.basic;

import com.my.model.Subscriber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SubscriberRepository {
    Page<Subscriber> findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrPatronymicContainingIgnoreCaseOrCityContainingIgnoreCaseOrStreetContainingIgnoreCaseOrPhoneNumberContainingIgnoreCase(String name, String lastName, String patronymic, String city, String street, String phoneNumber, Pageable pageable);
}

package com.my.repository.jpa;

import com.my.model.Subscriber;
import com.my.repository.basic.SubscriberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSubscriberRepository extends JpaRepository<Subscriber, String>, SubscriberRepository {
}

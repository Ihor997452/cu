package com.my.repository.jpa;

import com.my.model.Subscriber;
import com.my.repository.basic.SubscriberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSubscriberRepository extends JpaRepository<Subscriber, Integer>, SubscriberRepository {
}

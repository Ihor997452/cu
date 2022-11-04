package com.my.repository.mongo;

import com.my.model.Subscriber;
import com.my.repository.basic.SubscriberRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoSubscriberRepository extends MongoRepository<Subscriber, String>, SubscriberRepository {
}

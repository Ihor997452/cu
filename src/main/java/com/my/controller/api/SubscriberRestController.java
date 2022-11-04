package com.my.controller.api;

import com.my.model.MobileOperator;
import com.my.model.Subscriber;
import com.my.service.subscriber.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberRestController extends AbstractRestController<Subscriber, String> {
    public SubscriberRestController(SubscriberService service) {
        this.service = service;
    }

    @Override
    public Subscriber getPrototype() {
        Subscriber subscriber = new Subscriber();
        subscriber.setId("id");
        subscriber.setCity("city");
        subscriber.setName("name");
        subscriber.setPatronymic("patronymic");
        subscriber.setFlatNumber(0);
        subscriber.setHouseNumber(0);
        subscriber.setPhoneNumber("000000");
        subscriber.setLastName("lastName");
        subscriber.setPostCode(0);
        subscriber.setStreet("street");

        MobileOperator operator = new MobileOperator();
        operator.setId("0");
        operator.setHotline("0");
        operator.setEmail("0");
        operator.setName("0");

        subscriber.setOperator(operator);
        return subscriber;
    }
}

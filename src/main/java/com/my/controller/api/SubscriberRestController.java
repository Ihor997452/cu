package com.my.controller.api;

import com.my.model.Subscriber;
import com.my.service.subscriber.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberRestController extends AbstractRestController<Subscriber, Integer> {
    public SubscriberRestController(SubscriberService service) {
        this.service = service;
    }
}

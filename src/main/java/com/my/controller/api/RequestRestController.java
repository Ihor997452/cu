package com.my.controller.api;

import com.my.model.MobileOperator;
import com.my.model.Request;
import com.my.model.Subscriber;
import com.my.model.enums.RequestType;
import com.my.service.request.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requests")
public class RequestRestController extends AbstractRestController<Request, String> {
    public RequestRestController(RequestService service) {
        this.service = service;
    }

    @Override
    public Request getPrototype() {
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

        Request request = new Request();
        request.setRequestType(RequestType.CHANGE_NUMBER);
        request.setId("0");
        request.setDescription("desc");
        request.setSubscriber(subscriber);
        return request;
    }
}


package com.my.controller.api;

import com.my.model.Request;
import com.my.service.request.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requests")
public class RequestRestController extends AbstractRestController<Request, Integer> {
    public RequestRestController(RequestService service) {
        this.service = service;
    }
}


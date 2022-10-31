package com.my.controller.api;

import com.my.model.MobileOperator;
import com.my.service.mobileOperator.MobileOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mobile-operators")
public class MobileOperatorRestController extends AbstractRestController<MobileOperator, Integer> {
    public MobileOperatorRestController(MobileOperatorService service) {
        this.service = service;
    }
}

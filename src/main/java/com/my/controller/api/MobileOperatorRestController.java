package com.my.controller.api;

import com.my.model.MobileOperator;
import com.my.service.mobileOperator.MobileOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/operators")
public class MobileOperatorRestController extends AbstractRestController<MobileOperator, String> {
    public MobileOperatorRestController(MobileOperatorService service) {
        this.service = service;
    }

    @Override
    public MobileOperator getPrototype() {
        MobileOperator operator = new MobileOperator();
        operator.setId("0");
        operator.setHotline("0");
        operator.setEmail("0");
        operator.setName("0");
        return operator;
    }
}

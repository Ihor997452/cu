package com.my.controller.api;

import com.my.model.SpecialService;
import com.my.service.specialService.SpecialServiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/special-services")
public class SpecialServiceRestController extends AbstractRestController<SpecialService, Integer> {
    public SpecialServiceRestController(SpecialServiceService service) {
        this.service = service;
    }
}

package com.my.controller.api;

import com.my.model.SpecialService;
import com.my.service.specialService.SpecialServiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/specialServices")
public class SpecialServiceRestController extends AbstractRestController<SpecialService, String> {
    public SpecialServiceRestController(SpecialServiceService service) {
        this.service = service;
    }

    @Override
    public SpecialService getPrototype() {
        SpecialService specialService = new SpecialService();
        specialService.setPhoneNumber("0");
        specialService.setId("0");
        specialService.setName("0");
        return specialService;
    }
}

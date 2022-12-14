package com.my.controller.api;

import com.my.model.Administrator;
import com.my.service.administrator.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorRestController extends AbstractRestController<Administrator, String> {
    AdministratorRestController(AdministratorService administratorService) {
        this.service = administratorService;
    }

    @Override
    public Administrator getPrototype() {
        Administrator administrator = new Administrator();
        administrator.setId("id");
        administrator.setPassword("pass");
        administrator.setEmail("email@email.com");
        return administrator;
    }
}

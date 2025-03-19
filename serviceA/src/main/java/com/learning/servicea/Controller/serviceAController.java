package com.learning.servicea.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicea")
public class serviceAController {

    @Autowired
    private Environment environment;

    @GetMapping("/details")
    public String serviceadetails() {
        return "Fetched details from serviceA with port "+environment.getProperty("server.port");
    }
}

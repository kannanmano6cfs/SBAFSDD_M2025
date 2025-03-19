package com.learning.serviceb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceb")
public class serviceBController {

    @GetMapping("/details")
    public String servicebdetails() {
        return "Fetched details from serviceB";
    }
}

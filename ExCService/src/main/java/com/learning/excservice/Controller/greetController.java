package com.learning.excservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello Everyone!! I am running from Container!!";
    }
}

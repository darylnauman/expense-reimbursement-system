package com.ex.requestreimbursement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greetings() {
        return "Good day! Test controller.";
    }
}

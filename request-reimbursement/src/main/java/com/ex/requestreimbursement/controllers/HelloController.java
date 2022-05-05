package com.ex.requestreimbursement.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller to simply check Apache Tomcat is running and able to reach a simple endpoint
 */

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String greetings() {
        logger.info("Reached /hello endpoint - running greeting method");
        return "Good day! Test controller.";
    }
}

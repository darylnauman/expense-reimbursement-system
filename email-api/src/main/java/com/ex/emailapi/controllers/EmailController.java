package com.ex.emailapi.controllers;

import com.ex.emailapi.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping()
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sendemail")
    public String sendEmail() {

        emailSenderService.sendSimpleEmail("darylnauman@outlook.com",
                "Hello Daryl, This is a message from Spring Email App. You reimbursement request is approved.",
                "Reimbursement Approved from Spring Email App");

        return "Email sent successfully";
    }

    @GetMapping("/employees")
    public List<Object> getEmployees() {

        String url = "http://localhost:7000/api/employees";
        Object[] objects = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(objects);
    }
}
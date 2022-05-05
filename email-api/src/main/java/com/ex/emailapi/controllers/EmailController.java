package com.ex.emailapi.controllers;

import com.ex.emailapi.models.ReimbursementRequest;
import com.ex.emailapi.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String sendEmail(String item, String date, Float amount) {

        String body = "Hello, This is a message from Spring Email App regarding your reimbursement request submitted on " + date + ". Your purchase of " + item + " for $" + amount + " has been approved.";

        emailSenderService.sendSimpleEmail("darylnauman@outlook.com",
                body,
                "Reimbursement Approved from Spring Email App");

        return "Email sent successfully";
    }

    @GetMapping("/employees")
    public List<Object> getEmployees() {

        String url = "http://web1:7000/api/employees";
        Object[] objects = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(objects);
    }

    @GetMapping("/reimbursementrequest/{id}")
    public ReimbursementRequest getReimbursementRequestById(@PathVariable Integer id) {

        String url = "http://web1:7000/api/reimbursementrequests/" + id ;
        System.out.println("string url: " + url);

        ReimbursementRequest rr = restTemplate.getForObject(url, ReimbursementRequest.class);

        if (rr.getStatus().equals("approved")) {
            sendEmail(rr.getItem(), rr.getDate(), rr.getAmount());
        } else {
            System.out.println("Reimbursement has not been approved yet");
        }

        return rr;
    }
}
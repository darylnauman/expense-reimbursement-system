package com.ex.emailapi.controllers;

import com.ex.emailapi.models.ReimbursementRequest;
import com.ex.emailapi.services.EmailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * REST controller to check status of a reimbursement that uses a RestTemplate to reach endpoint of reimbursement
 * application receiving an object back; if reimbursement has a status of approved will call method to send email
 */

@RestController
@RequestMapping()
public class EmailController {

    Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sendemail")
    public ResponseEntity sendEmail(String item, String date, Float amount) {

        String toEmail = "darylnauman@outlook.com";
        String body = "Hello, This is a message from Spring Email App regarding your reimbursement request submitted on " + date + ". Your purchase of " + item + " for $" + amount + " has been approved.";
        String subject = "Reimbursement Approved from Spring Email App";

        emailSenderService.sendSimpleEmail(toEmail, body, subject);

        return ResponseEntity.ok().body("Reimbursement email sent!");
    }

    @GetMapping("/employees")
    public List<Object> getEmployees() {

        String url = "http://web1:7000/api/employees";
        Object[] objects = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(objects);
    }

    @GetMapping("/reimbursementrequest/{id}")
    public ReimbursementRequest getReimbursementRequestById(@PathVariable Integer id) {

        logger.info("Endpoint reached: /reimbursementrequest/" + id);

        logger.info("Preparing Rest Template to reach reimbursement application");
        String url = "http://web1:7000/api/reimbursementrequests/" + id ;
        System.out.println("string url: " + url);

        ReimbursementRequest rr = restTemplate.getForObject(url, ReimbursementRequest.class);

        if (rr.getStatus().equals("approved")) {
            sendEmail(rr.getItem(), rr.getDate(), rr.getAmount());
        } else {
            logger.info("Reimbursement has not been approved yet - no email sent");
        }

        return rr;
    }
}
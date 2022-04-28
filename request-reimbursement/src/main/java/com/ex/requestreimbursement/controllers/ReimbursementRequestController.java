package com.ex.requestreimbursement.controllers;

import com.ex.requestreimbursement.models.ReimbursementRequest;
import com.ex.requestreimbursement.repositories.ReimbursementRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReimbursementRequestController {

    @Autowired
    ReimbursementRequestRepository reimbursementRequests;

    @PostMapping("/reimbursementrequsts")
    public ResponseEntity createReimbursementRequest(@RequestBody ReimbursementRequest newReimbursementRequest) {
        reimbursementRequests.save(newReimbursementRequest);
        System.out.println("Reached POST api/reimbursementrequst end point to create");
        return ResponseEntity.ok().body("Reached POST api/reimbursementrequst end point to create");
    }

    @GetMapping("/reimbursementrequsts")
    public List<ReimbursementRequest> getAllReimbursementRequests() {
        return reimbursementRequests.findAll();
    }

    @GetMapping("/reimbursementrequsts/{id}")
    public Optional<ReimbursementRequest> getReimbursementRequestById(@PathVariable Integer id) {
        Optional<ReimbursementRequest> reimbursementRequest = reimbursementRequests.findById(id);
        System.out.println("Reached GET api/reimbursementrequests/" + id + " end point");
        return reimbursementRequest;
    }

    @PutMapping("/reimbursementrequsts/{id}")
    public ResponseEntity updateReimbursementRequest(@PathVariable Integer id) {
        System.out.println("Reached PUT api/reimbursementrequests/" + id + " end point");
        return ResponseEntity.ok().body("Reached PUT api/reimbursementrequests/" + id + " end point");
    }

    @DeleteMapping("/reimbursementrequsts/{id}")
    public ResponseEntity deleteReimbursementRequest(@PathVariable Integer id) {
        System.out.println("Reached DELETE api/reimbursementrequests/" + id + " end point");
        return ResponseEntity.ok().body("Reached DELETE api/reimbursementrequests/" + id + " end point");
    }


}

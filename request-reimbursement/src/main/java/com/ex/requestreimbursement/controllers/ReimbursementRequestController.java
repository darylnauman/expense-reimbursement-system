package com.ex.requestreimbursement.controllers;

import com.ex.requestreimbursement.models.ReimbursementRequest;
import com.ex.requestreimbursement.repositories.ReimbursementRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReimbursementRequestController {

    @Autowired
    ReimbursementRequestRepository reimbursementRequests;

    @PostMapping("/reimbursementrequsts")
    public ResponseEntity createReimbursementRequest(@RequestBody ReimbursementRequest newReimbursementRequest) {
        try {
            reimbursementRequests.save(newReimbursementRequest);
            return ResponseEntity.ok("Reimbursement request submitted for review.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error saving new reimbursement request");
        }
    }

    @GetMapping("/reimbursementrequsts")
    public ResponseEntity getAllReimbursementRequests() {
        return ResponseEntity.ok(reimbursementRequests.findAll());
    }

    @GetMapping("/reimbursementrequsts/{id}")
    public ResponseEntity getReimbursementRequestById(@PathVariable Integer id) {
        Optional<ReimbursementRequest> reimbursementRequest = reimbursementRequests.findById(id);

        if(reimbursementRequest.isPresent()) {
            return ResponseEntity.ok(reimbursementRequest);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/reimbursementrequsts/{id}")
    public ResponseEntity updateReimbursementRequest(@PathVariable Integer id) {
        try {
            // TODO Add the correct logic to update a reimbursement request
            System.out.println("Reached PUT api/reimbursementrequests/" + id + " end point");
            return ResponseEntity.ok().body("Reached PUT api/reimbursementrequests/" + id + " end point");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("update reimbursement failed");
        }
    }

    @DeleteMapping("/reimbursementrequsts/{id}")
    public ResponseEntity deleteReimbursementRequest(@PathVariable Integer id) {
        try {
            // TODO Create delete request logic
            System.out.println("Reached DELETE api/reimbursementrequests/" + id + " end point");
            return ResponseEntity.ok().body("Reached DELETE api/reimbursementrequests/" + id + " end point");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error deleting reimbursement request");
        }
    }
}

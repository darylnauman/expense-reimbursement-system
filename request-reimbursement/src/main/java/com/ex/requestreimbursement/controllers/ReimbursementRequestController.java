package com.ex.requestreimbursement.controllers;

import com.ex.requestreimbursement.models.Action;
import com.ex.requestreimbursement.models.ReimbursementRequest;
import com.ex.requestreimbursement.services.ReimbursementRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reimbursementrequsts")
public class ReimbursementRequestController {

    Logger logger = LoggerFactory.getLogger(ReimbursementRequestController.class);

    @Autowired
    ReimbursementRequestService reimbursementRequestService;

    @PostMapping
    public ResponseEntity createReimbursementRequest(@RequestBody ReimbursementRequest newReimbursementRequest) {
        logger.info("ReimbursementRequestController - POST mapping for create reimbursement request");
        try {
            newReimbursementRequest = reimbursementRequestService.saveReimbursementRequest(newReimbursementRequest);

            if (newReimbursementRequest != null) {
                return ResponseEntity.ok("Reimbursement request created");
            } else {
                return ResponseEntity.internalServerError().body("Error saving reimbursement request");
            }
        } catch (Exception e) {
            logger.warn("ReimbursementRequestController - catch block for createReimbursementRequest");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error saving new reimbursement request");
        }
    }

    @GetMapping
    public ResponseEntity getAllReimbursementRequests() {
        logger.info("ReimbursementRequestController - GET mapping for getAllReimbursementRequests");
        try {
            List<ReimbursementRequest> reimbursementRequests = reimbursementRequestService.findAllReimbursementRequests();
            return ResponseEntity.ok(reimbursementRequests);
        } catch (Exception e) {
            logger.warn("ReimbursementRequestController - catch block for getAllReimbursementRequests");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error getting all reimbursement requests");
        }
    }

    @GetMapping("/manager/{managerId}")
    public ResponseEntity getAllReimbursementRequestsByManagerId(@PathVariable Integer managerId) {
        logger.info("ReimbursementRequestController - GET mapping for getAllReimbursementRequestsByManagerId");
        try {
            List<ReimbursementRequest> reimbursementRequests = reimbursementRequestService.findAllReimbursementRequestsByManagerId(managerId);
            return ResponseEntity.ok(reimbursementRequests);
        } catch (Exception e) {
            logger.warn("ReimbursementRequestController - catch block for getAllReimbursementRequestsByManagerId");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error getting all reimbursement requests by managerId");
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity getAllReimbursementRequestsByEmployeeId(@PathVariable Integer employeeId) {
        logger.info("ReimbursementRequestController - GET mapping for getAllReimbursementRequestsByEmployeeId");
        try {
            List<ReimbursementRequest> reimbursementRequests = reimbursementRequestService.findAllReimbursementRequestsByEmployeeId(employeeId);
            return ResponseEntity.ok(reimbursementRequests);
        } catch (Exception e) {
            logger.warn("ReimbursementRequestController - catch block for getAllReimbursementRequestsByEmployeeId");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error getting all reimbursement requests by employeeId");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getReimbursementRequestById(@PathVariable Integer id) {
        logger.info("ReimbursementRequestController - GET mapping for getReimbursementRequestById");
        try {
            Optional<ReimbursementRequest> reimbursementRequest = reimbursementRequestService.findById(id);

            if(reimbursementRequest.isPresent()) {
                return ResponseEntity.ok(reimbursementRequest);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.warn("ReimbursementRequestController - catch block for getReimbursementRequestById");
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Reimbursement request not found");
        }
    }

    @PutMapping("{id}/{revisedManagerId}")
    public ResponseEntity reassignReimbursementRequest(@PathVariable Integer id, @PathVariable Integer revisedManagerId) {
        logger.info("ReimbursementRequestController - PUT mapping for reassignReimbursementRequest");
        try {
            reimbursementRequestService.reassignReimbursementRequest(id, revisedManagerId);
            return ResponseEntity.ok().body("Success - reassigned to " + revisedManagerId);
        } catch (Exception e) {
            logger.warn("ReimbursementRequestController - catch block for reassignReimbursementRequest");
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Reassign reimbursement request failed");
        }
    }

    @PutMapping("{id}/action")
    public ResponseEntity updateStatusReimbursementRequest(@PathVariable Integer id, @RequestBody Action action) {
        logger.info("ReimbursementRequestController - PUT mapping for updateStatusReimbursementRequest");
        try {
            reimbursementRequestService.updateStatus(id, action);
            return ResponseEntity.ok().body("Success - updated status to " + action.getType());
        } catch (Exception e) {
            logger.warn("ReimbursementRequestController - catch block for updateStatusReimbursementRequest");
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Update reimbursement request status failed");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteReimbursementRequest(@PathVariable Integer id) {
        logger.info("ReimbursementRequestController - DELETE mapping for deleteReimbursementRequest");
        try {
            boolean success = reimbursementRequestService.deleteReimbursementRequest(id);

            if (success) {
                return ResponseEntity.ok("Reimbursement request deleted");
            } else {
                return ResponseEntity.internalServerError().body("Error deleting reimbursement request");
            }
        } catch (Exception e) {
            logger.warn("ReimbursementRequestController - catch block for deleteReimbursementRequest");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error deleting reimbursement request");
        }
    }
}
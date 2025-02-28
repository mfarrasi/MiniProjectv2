package com.example.miniprojectjava.controller;

import com.example.miniprojectjava.entity.TransactionType;
import com.example.miniprojectjava.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction-type")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping
    public List<TransactionType> getAllTransactionType() { return transactionTypeService.getAllTransactionType();}

    @GetMapping("/getTransactionType")
    public TransactionType getTransactionTypeById(int id) { return transactionTypeService.getTransactionTypeById(id);}

    @PostMapping("/createTransactionType")
    public ResponseEntity<TransactionType> create (@RequestBody TransactionType request) {
        TransactionType response = request;

        response = transactionTypeService.createTransactionType(request);

        return ResponseEntity.ok(response);
    }
}

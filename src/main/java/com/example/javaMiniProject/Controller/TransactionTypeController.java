package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.Entity.TransactionType;
import com.example.javaMiniProject.services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class TransactionTypeController {
    @Autowired
    TransactionTypeService transactionTypeService;

    // CREATE
    @PostMapping("/createTransactionType")
    public ResponseEntity<TransactionType> create (@RequestBody TransactionType request){
        TransactionType response = request;

        response = transactionTypeService.createTransactionType(request);

        return ResponseEntity.ok(response);
    }

    // READ
    @GetMapping("/getTransactionType")
    public ResponseEntity<TransactionType> getTransactionType(@RequestParam String param){
        TransactionType response = new TransactionType();

        response = transactionTypeService.getTransactionType(param);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getTransactionTypeByName")
    public ResponseEntity<TransactionType> getTransactionTypeByName(@RequestParam String param){
        TransactionType response = new TransactionType();

        response = transactionTypeService.getTransactionTypeByName(param);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getListByTransactionTypeId")
    public ResponseEntity<List<TransactionType>> getListByTypeId(@RequestParam String param){

        List<TransactionType> response= transactionTypeService.getListByTypeId(param);

        return ResponseEntity.ok(response);
    }

    // UPDATE
//    @PutMapping("/updateTransactionType")
//    public ResponseEntity<TransactionType> updateTransactionType(@RequestBody TransactionType request){
//        TransactionType response = new TransactionType();
//
//        response = transactionTypeService.updateTransactionType(request);
//
//        return ResponseEntity.ok(response);
//    }
}

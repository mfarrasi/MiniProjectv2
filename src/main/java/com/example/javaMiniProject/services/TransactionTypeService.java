package com.example.javaMiniProject.services;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.Entity.TransactionType;
import com.example.javaMiniProject.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TransactionTypeService {
    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    // CREATE
    public TransactionType createTransactionType(TransactionType request){
        try{
            TransactionType response = request;
            transactionTypeRepository.save(response);
            response.setRc("0000");
            response.setRcDesc("Success");

            return response;
        }
        catch (Exception e){
            TransactionType response = request;
            response.setRc("0005");
            response.setRcDesc("General Error");

            return response;

        }

    }

    // READ
    public TransactionType getTransactionType(String param){
        TransactionType response = new TransactionType();

        response = transactionTypeRepository.findById(Integer.parseInt(param)).get();

        return response;
    }

    public TransactionType getTransactionTypeByName(String param) {
        TransactionType response = new TransactionType();

        response = transactionTypeRepository.findByTypeName(param);

        return response;
    }

    public List<TransactionType> getListByTypeId(String param){
        List<TransactionType> response = new ArrayList<>();

        response = transactionTypeRepository.findAllByTypeId(Integer.valueOf(param));

        return response;
    }
}

package com.example.javaMiniProject.repository;

import com.example.javaMiniProject.Entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer>{
    TransactionType findByTypeName (String typeName);
    List<TransactionType> findAllByTypeId(Integer typeId);
}

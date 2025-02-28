package com.example.javaMiniProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "m_transaction_type")
public class mTransactionType {
    @Id
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "type_name")
    private String typeName;

//    @Column(name = "created_at")
//    private Timestamp createdAt;
//
//    @Column(name = "updated_at")
//    private Timestamp updatedAt;
}

package com.example.javaMiniProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class sUser {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    private String Ghani;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

//    @Column(name = "created_at")
//    private Timestamp createdAt;
//
//    @Column(name = "updated_at")
//    private Timestamp updatedAt;
}

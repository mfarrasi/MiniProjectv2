package com.example.miniprojectjava.repository;

import com.example.miniprojectjava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

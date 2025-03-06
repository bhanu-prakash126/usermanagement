package com.example.userapp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userapp.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findByManagerId(UUID manager_id);
    User findByUserId(UUID user_id);
    User findByMobNum(String mob_num);
}
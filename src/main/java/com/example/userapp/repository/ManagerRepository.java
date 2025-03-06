package com.example.userapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userapp.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {
    boolean existsByManagerIdAndIsActive(UUID manager_id, boolean is_active);
}
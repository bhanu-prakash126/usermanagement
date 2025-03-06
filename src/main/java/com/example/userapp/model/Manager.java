package com.example.userapp.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Manager {
    @Id
    private UUID manager_id;
    private String full_name;
    private boolean is_active;
}
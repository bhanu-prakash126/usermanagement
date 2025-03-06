package com.example.userapp.service;

import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userapp.repository.ManagerRepository;

@Service
public class ValidationService {
    @Autowired
    private ManagerRepository managerRepository;

    public boolean isValidFullName(String full_name) {
        return full_name != null && !full_name.trim().isEmpty();
    }

    public boolean isValidMobileNumber(String mob_num) {
        mob_num = mob_num.replaceAll("[^0-9]", "");
        return mob_num.length() == 10;
    }

    public boolean isValidPanNumber(String pan_num) {
        return Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}", pan_num.toUpperCase());
    }

    public boolean isValidManager(UUID manager_id) {
        return managerRepository.existsByManagerIdAndIsActive(manager_id, true);
    }
}
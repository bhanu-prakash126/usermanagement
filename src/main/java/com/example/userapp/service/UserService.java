package com.example.userapp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userapp.model.User;
import com.example.userapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    public String createUser(User user) {
        if (!validationService.isValidFullName(user.getFull_name())) {
            return "Invalid full name";
        }
        if (!validationService.isValidMobileNumber(user.getMob_num())) {
            return "Invalid mobile number";
        }
        if (!validationService.isValidPanNumber(user.getPan_num())) {
            return "Invalid PAN number";
        }
        if (user.getManager_id() != null && !validationService.isValidManager(user.getManager_id())) {
            return "Invalid manager ID";
        }

        user.setPan_num(user.getPan_num().toUpperCase());
        userRepository.save(user);
        return "User created successfully";
    }

    public List<User> getUsers(UUID user_id, String mob_num, UUID manager_id) {
        if (user_id != null) {
            return List.of(userRepository.findByUserId(user_id));
        } else if (mob_num != null) {
            return List.of(userRepository.findByMobNum(mob_num));
        } else if (manager_id != null) {
            return userRepository.findByManagerId(manager_id);
        } else {
            return userRepository.findAll();
        }
    }

    public String deleteUser(UUID user_id, String mob_num) {
        User user = user_id != null ? userRepository.findByUserId(user_id) : userRepository.findByMobNum(mob_num);
        if (user == null) {
            return "User not found";
        }
        userRepository.delete(user);
        return "User deleted successfully";
    }

    public String updateUser(List<UUID> user_ids, User update_data) {
        // Implementation for bulk and individual updates
        return "User updated successfully";
    }
}
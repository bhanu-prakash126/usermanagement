package com.example.userapp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userapp.model.User;
import com.example.userapp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/get_users")
    public List<User> getUsers(@RequestParam(required = false) UUID user_id,
                               @RequestParam(required = false) String mob_num,
                               @RequestParam(required = false) UUID manager_id) {
        return userService.getUsers(user_id, mob_num, manager_id);
    }

    @PostMapping("/delete_user")
    public String deleteUser(@RequestParam(required = false) UUID user_id,
                            @RequestParam(required = false) String mob_num) {
        return userService.deleteUser(user_id, mob_num);
    }

    @PostMapping("/update_user")
    public String updateUser(@RequestParam List<UUID> user_ids, @RequestBody User update_data) {
        return userService.updateUser(user_ids, update_data);
    }
}
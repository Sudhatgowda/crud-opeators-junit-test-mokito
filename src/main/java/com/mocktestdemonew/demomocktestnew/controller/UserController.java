package com.mocktestdemonew.demomocktestnew.controller;

import com.mocktestdemonew.demomocktestnew.model.User;
import com.mocktestdemonew.demomocktestnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User save(@RequestBody User user)
    {
        return service.saveUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers()
    {
        return service.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id)
    {
        service.deleteUserById(id);
    }
}

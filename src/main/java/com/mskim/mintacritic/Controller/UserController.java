package com.mskim.mintacritic.Controller;


import com.mskim.mintacritic.Entity.User;
import com.mskim.mintacritic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ArrayList<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("")
    public User registerNewUser(User user) {
        return userService.register(user);
    }

    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable String userid) {
        userService.deleteUser(userid);
    }
}

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

    @GetMapping("/check/id/{userid}")
    public int checkIDDuplicate(@PathVariable String userid) {
        return userService.checkIDDuplicate(userid);
    }

    @GetMapping("/check/nickname/{nickname}")
    public int checkNicknameDuplicate(@PathVariable String nickname) {
        return userService.checkNicknameDuplicate(nickname);
    }

    @GetMapping("")
    public ArrayList<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{userid}")
    public String getPasswordByUserID(@PathVariable String userid) {
        return userService.findUserByID(userid).orElse(new User("", "", "")).getPassword();
    }

    @PostMapping("")
    public User registerNewUser(@RequestParam String userid, @RequestParam String password, @RequestParam String nickname) {
        return userService.register(userid, password, nickname);
    }

    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable String userid) {
        userService.deleteUser(userid);
    }
}

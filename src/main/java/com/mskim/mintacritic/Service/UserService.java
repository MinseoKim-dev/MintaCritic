package com.mskim.mintacritic.Service;

import com.mskim.mintacritic.Entity.Album;
import com.mskim.mintacritic.Entity.User;
import com.mskim.mintacritic.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<User> findAllUsers() {
        ArrayList<User> users = new ArrayList<>(userRepository.findAll());
        return users;
    }

    public Optional<User> findUserByID(String userID) {
        return userRepository.findUserByUserID(userID);
    }

    public User register(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(String userID) {
        userRepository.deleteUserByUserID(userID);
    }

}

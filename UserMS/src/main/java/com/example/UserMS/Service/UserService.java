package com.example.UserMS.Service;


import com.example.UserMS.Entity.User;
import com.example.UserMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;


    public User saveUser(User user) {
        userRepo.save(user);
        return user;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }


    public void deleteUser(Long userID) {
        userRepo.deleteById(userID);
    }
}

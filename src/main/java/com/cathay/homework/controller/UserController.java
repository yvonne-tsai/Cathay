package com.cathay.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.homework.entity.User;
import com.cathay.homework.model.UserPojo;
import com.cathay.homework.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody UserPojo userPojo) {
        User user = new User();
        user.setName(userPojo.getName());
        user.setSurname(userPojo.getSurname());
        userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}

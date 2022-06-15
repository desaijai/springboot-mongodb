package com.mongodb.userDetailsMongo.controller;

import com.mongodb.userDetailsMongo.model.User;
import com.mongodb.userDetailsMongo.model.dbSequence;
import com.mongodb.userDetailsMongo.repository.userRepo;
import com.mongodb.userDetailsMongo.service.seqGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class userController {

    @Autowired
    seqGenerateService service;

    @Autowired
    userRepo repo;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        user.setUid(service.generateId(User.GENERATE_SEQUENCE));
        return new ResponseEntity<>(repo.save(user), HttpStatus.CREATED);
    }

}

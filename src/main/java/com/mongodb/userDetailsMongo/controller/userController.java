package com.mongodb.userDetailsMongo.controller;

import com.mongodb.userDetailsMongo.exception.resourceNotFound;
import com.mongodb.userDetailsMongo.model.User;
import com.mongodb.userDetailsMongo.model.dbSequence;
import com.mongodb.userDetailsMongo.repository.userRepo;
import com.mongodb.userDetailsMongo.service.seqGenerateService;
import com.mongodb.userDetailsMongo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class userController {

    @Autowired
    seqGenerateService service;

    @Autowired
    userService uservice;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        user.setUid(service.generateId(User.GENERATE_SEQUENCE));
        return new ResponseEntity<>(uservice.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUser() {
        return uservice.getAllUser();
    }

    @GetMapping("{uid}")
    public ResponseEntity<User> getUserById(@PathVariable("uid") int uid) {
        return new ResponseEntity<>(uservice.findUserById(uid),HttpStatus.OK);
    }

    @PutMapping("{uid}")
    public ResponseEntity<User> updateUserById(@PathVariable("uid") int uid, @RequestBody User user) {
        return new ResponseEntity<>(uservice.updateUser(user, uid), HttpStatus.OK);
    }

    @DeleteMapping("{uid}")
    public ResponseEntity<String> deleteUserById(@PathVariable("uid") int uid) {
        uservice.deleteUser(uid);
        return new ResponseEntity<>("item deleted successfully!", HttpStatus.OK);
    }
}

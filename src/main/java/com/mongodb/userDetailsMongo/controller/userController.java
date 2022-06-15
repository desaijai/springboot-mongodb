package com.mongodb.userDetailsMongo.controller;

import com.mongodb.userDetailsMongo.exception.resourceNotFound;
import com.mongodb.userDetailsMongo.model.User;
import com.mongodb.userDetailsMongo.model.dbSequence;
import com.mongodb.userDetailsMongo.repository.userRepo;
import com.mongodb.userDetailsMongo.service.seqGenerateService;
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
    userRepo repo;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        user.setUid(service.generateId(User.GENERATE_SEQUENCE));
        return new ResponseEntity<>(repo.save(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUser(){
        return repo.findAll();
    }

    @GetMapping("{uid}")
    public ResponseEntity<User> getUserById(@PathVariable("uid") int uid){
        return new ResponseEntity<>(repo.findById(uid).orElseThrow(()->new resourceNotFound("user","uid",uid)),HttpStatus.OK);
    }

    @PutMapping("{uid}")
    public ResponseEntity<User> updateUserById(@PathVariable("uid") int uid,@RequestBody User user){
        User oldUser=repo.findById(uid).orElseThrow(()->new resourceNotFound("user","uid",uid));
        oldUser.setUname(user.getUname());
        oldUser.setUemail(user.getUpassword());
        oldUser.setUpassword(user.getUpassword());
        oldUser.setUpdateOn(user.getUpdateOn());
        return new ResponseEntity<>(repo.save(oldUser),HttpStatus.OK);
    }

    @DeleteMapping("{uid}")
    public ResponseEntity<String> deleteUserById(@PathVariable("uid") int uid){
        User user=repo.findById(uid).orElseThrow(()->new resourceNotFound("user","uid",uid));
        repo.delete(user);
        return new ResponseEntity<>("item deleted successfully!",HttpStatus.OK);
    }
}

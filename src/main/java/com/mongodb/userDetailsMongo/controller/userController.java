package com.mongodb.userDetailsMongo.controller;

import com.mongodb.userDetailsMongo.model.Accounts;
import com.mongodb.userDetailsMongo.model.User;
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
    userService uservice;

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(uservice.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping(produces = {"application/json"})
    public List<User> getAllUser() {
        return uservice.getAllUser();
    }

    @GetMapping(value = "{uid}",produces = {"application/json"})
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

    @GetMapping(value = "get/{uname}",produces = {"application/json"})
    public List<User> findByUserName(@PathVariable("uname") String uname){
        return uservice.findByUserName(uname);
    }

    @GetMapping("/accounts")
    public List<Accounts> getAllAccounts(){
        return uservice.getAllAccounts();
    }

    @PostMapping("/accounts")
    public ResponseEntity<Accounts> saveAccount(@RequestBody Accounts accounts){
        return new ResponseEntity<>(uservice.saveAccount(accounts),HttpStatus.OK);
    }

    @GetMapping("findBycity/{cityName}")
    public List<User> findByCityName(@PathVariable("cityName") String cityName){
        return uservice.findByCityName(cityName);
    }

}

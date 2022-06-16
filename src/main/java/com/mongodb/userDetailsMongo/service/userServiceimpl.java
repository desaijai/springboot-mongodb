package com.mongodb.userDetailsMongo.service;

import com.mongodb.userDetailsMongo.exception.resourceNotFound;
import com.mongodb.userDetailsMongo.model.User;
import com.mongodb.userDetailsMongo.repository.userRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceimpl implements userService{

    private userRepo repo;

    public userServiceimpl(userRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAllUser() {
        List<User> getAllUsers=repo.findAll();
        return getAllUsers;
    }

    @Override
    public User findUserById(int uid) {
        User findedUser=repo.findById(uid).orElseThrow(()->new resourceNotFound("User","uid",uid));
        return findedUser;
    }

    @Override
    public User saveUser(User user) {
        return repo.save(user);
    }

    @Override
    public User updateUser(User user, int uid) {
        User oldUser=repo.findById(uid).orElseThrow(()->new resourceNotFound("User","uid",uid));
        oldUser.setUname(user.getUname());
        oldUser.setUemail(user.getUemail());
        oldUser.setUpassword(user.getUpassword());
        oldUser.setUaccounts(user.getUaccounts());
        oldUser.setUpdateOn(user.getUpdateOn());
        return oldUser;
    }

    @Override
    public void deleteUser(int uid) {
        User find=repo.findById(uid).orElseThrow(()->new resourceNotFound("User","uid",uid));
        repo.delete(find);
    }


}

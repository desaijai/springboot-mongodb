package com.mongodb.userDetailsMongo.service;

import com.mongodb.userDetailsMongo.model.User;

import java.util.List;

public interface userService {

    public List<User> getAllUser();

    public User findUserById(int uid);

    public User saveUser(User user);

    public User updateUser(User user,int uid);

    public void deleteUser(int uid);

}

package com.mongodb.userDetailsMongo.service;

import com.mongodb.userDetailsMongo.dto.userdto;
import com.mongodb.userDetailsMongo.model.Accounts;
import com.mongodb.userDetailsMongo.model.User;

import java.util.List;

public interface userService {

    public List<User> getAllUser();

    public User findUserById(int uid);

    public User saveUser(User user);

    public User updateUser(User user,int uid);

    public void deleteUser(int uid);

    public List<User> findByUserName(String uname);

    //account class crud
    public List<Accounts> getAllAccounts();

    public Accounts saveAccount(Accounts accounts);

    public List<User> findByCityName(String cityName);

    public List<User> saveBulkOfUser(List<User> users);
}

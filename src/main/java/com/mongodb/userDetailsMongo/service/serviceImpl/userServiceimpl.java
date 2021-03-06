package com.mongodb.userDetailsMongo.service.serviceImpl;

import com.mongodb.userDetailsMongo.dto.userdto;
import com.mongodb.userDetailsMongo.exception.resourceNotFound;
import com.mongodb.userDetailsMongo.model.Accounts;
import com.mongodb.userDetailsMongo.model.Address;
import com.mongodb.userDetailsMongo.model.User;
import com.mongodb.userDetailsMongo.model.product;
import com.mongodb.userDetailsMongo.repository.accountRepo;
import com.mongodb.userDetailsMongo.repository.userRepo;
import com.mongodb.userDetailsMongo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class userServiceimpl implements userService {

    @Autowired
    private userRepo repo;

    @Autowired
    private accountRepo arepo;

    @Autowired
    private seqGenerateService serviceGenerator;

    @Override
    public List<User> getAllUser() {
        List<User> getAllUsers = repo.findAll();
        return getAllUsers;
    }

    @Override
    public User findUserById(int uid) {
        User findedUser = repo.findById(uid).orElseThrow(() -> new resourceNotFound("User", "uid", uid));
        return findedUser;
    }

    @Override
    public User saveUser(User user) {
        user.setUid(serviceGenerator.generateId(User.GENERATE_SEQUENCE));
        user.getUaddress().setAid(serviceGenerator.generateId(Address.ADDRESSKEY_GENERATE));
        user.getUproducts().forEach((element) -> {
            element.setPid(serviceGenerator.generateId(product.PRODUCTKEY_GENERATE));
        });
        return repo.save(user);
    }

    @Override
    public User updateUser(User user, int uid) {
        User oldUser = repo.findById(uid).orElseThrow(() -> new resourceNotFound("User", "uid", uid));
        oldUser.setUname(user.getUname());
        oldUser.setUemail(user.getUemail());
        oldUser.setUpassword(user.getUpassword());
        oldUser.setUaccounts(user.getUaccounts());
        oldUser.setUaddress(user.getUaddress());
        oldUser.setUproducts(user.getUproducts());
        oldUser.setUpdateOn(user.getUpdateOn());
        return repo.save(oldUser);
    }

    @Override
    public void deleteUser(int uid) {
        User find = repo.findById(uid).orElseThrow(() -> new resourceNotFound("User", "uid", uid));
        repo.delete(find);
    }

    @Override
    public List<User> findByUserName(String uname) {
        return repo.findByuname(uname);
    }

    @Override
    public List<Accounts> getAllAccounts() {
        return arepo.findAll();
    }

    @Override
    public Accounts saveAccount(Accounts accounts) {
        accounts.setAid(serviceGenerator.generateId(Accounts.ACCOUNT_SEQUENCE));
        return arepo.save(accounts);
    }

    @Override
    public List<User> findByCityName(String cityName) {
        return repo.findByCityName(cityName);
    }

    @Override
    public List<User> saveBulkOfUser(List<User> users) {
        users.forEach((element) -> {
            element.setUid(serviceGenerator.generateId(User.GENERATE_SEQUENCE));
            element.getUaddress().setAid(serviceGenerator.generateId(Address.ADDRESSKEY_GENERATE));
            element.getUproducts().forEach((element1) -> {
                element1.setPid(serviceGenerator.generateId(product.PRODUCTKEY_GENERATE));
            });
        });
        return repo.saveAll(users);
    }

}

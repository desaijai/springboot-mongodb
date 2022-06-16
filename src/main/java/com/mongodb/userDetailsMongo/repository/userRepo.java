package com.mongodb.userDetailsMongo.repository;

import com.mongodb.userDetailsMongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface userRepo extends MongoRepository<User,Integer> {

    List<User> findByuname(String uname);

    @Query("{'uaddress.cityName':?0}")
    List<User> findByCityName(String cityName);

}

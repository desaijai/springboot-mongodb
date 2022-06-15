package com.mongodb.userDetailsMongo.repository;

import com.mongodb.userDetailsMongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepo extends MongoRepository<User,Integer> {

}

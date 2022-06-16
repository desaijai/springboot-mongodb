package com.mongodb.userDetailsMongo.repository;

import com.mongodb.userDetailsMongo.model.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface accountRepo extends MongoRepository<Accounts,Integer> {
}

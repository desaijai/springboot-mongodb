package com.mongodb.userDetailsMongo.service;

import com.mongodb.userDetailsMongo.model.dbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class seqGenerateService {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateId(String seqName){

        //get the value from the generatevalue table
        Query query=new Query(Criteria.where("id").is(seqName));

        //now update the sequence value of which is getting from query
        Update update=new Update().inc("seq",1);

        //modify the document
        dbSequence counter=mongoOperations.findAndModify(query,update,options().returnNew(true).upsert(true),dbSequence.class);

        return !Objects.isNull(counter)?counter.getSeq():1;
    }
}

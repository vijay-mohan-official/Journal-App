package com.learning.journalApp.repository;

import com.learning.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryImpl {

    //MongoTemplate is provided by Spring Mongo Data for Spring Boot to interact with MongoDB
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUserForSentimentAnalysis(){
        //Using criteria to fetch data. Query and Criteria goes hand in hand
        Query query = new Query();
        //Adding Criteria or rules to filter data
        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
        //Brilliant example of ORM, we are not providing collection name, we are providing class name 
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

}

package com.learning.journalapp.service;

import com.learning.journalapp.entity.User;
import com.learning.journalapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user){
        try{
            userRepository.save(user);
        }catch (Exception e){
            log.error("Exception",e);
        }
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId myId) {
        return userRepository.findById(myId);
    }

    public void deleteById(ObjectId myId){
        userRepository.deleteById(myId);
    }

    public User findByUsername(String userName){
        return userRepository.findByUserName(userName);
    }
}

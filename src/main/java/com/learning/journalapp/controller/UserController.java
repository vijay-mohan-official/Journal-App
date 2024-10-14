package com.learning.journalapp.controller;

import com.learning.journalapp.entity.User;
import com.learning.journalapp.repository.UserRepository;
import com.learning.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //Moved create user to another controller which is public to all

    //We'll create get all users for Admin user
//    @GetMapping
//    public List<User> getAll(){
//        return userService.getAll();
//    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user){
        //Authenticated requests will only reach here, hence userDetails will be available in Security Context and hence we don't need to pass userName as Path Variable
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUsername(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUserById(){
        //Authenticated requests will only reach here, hence userDetails will be available in Security Context and hence we don't need to pass userName as Path Variable
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

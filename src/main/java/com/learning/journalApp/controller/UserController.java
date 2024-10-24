package com.learning.journalApp.controller;

import com.learning.journalApp.api.response.WeatherResponse;
import com.learning.journalApp.dto.UserLoginDTO;
import com.learning.journalApp.entity.User;
import com.learning.journalApp.repository.UserRepository;
import com.learning.journalApp.service.UserService;
import com.learning.journalApp.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User APIs", description = "Update, Delete User and Greetings(Weather) APIs")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    //Moved create user to another controller which is public to all

    //We'll create get all users for Admin user
//    @GetMapping
//    public List<User> getAll(){
//        return userService.getAll();
//    }

    @PutMapping()
    @Operation(summary = "Update User details")
    public ResponseEntity<?> updateUser(@RequestBody UserLoginDTO user){
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
    @Operation(summary = "Delete a User by Id")
    public ResponseEntity<?> deleteUserById(){
        //Authenticated requests will only reach here, hence userDetails will be available in Security Context and hence we don't need to pass userName as Path Variable
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @Operation(summary = "Greetings API to fetch Weather")
    public ResponseEntity<?> greetings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        String greeting = "";
        if(weatherResponse != null){
            greeting = ", Weather feels like "+weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi "+authentication.getName()+greeting,HttpStatus.OK);
    }

}

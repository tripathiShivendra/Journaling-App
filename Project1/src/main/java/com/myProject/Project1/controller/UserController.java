package com.myProject.Project1.controller;


import com.myProject.Project1.entity.User;
import com.myProject.Project1.repository.UserRepository;
import com.myProject.Project1.service.UserService;
import com.myProject.Project1.service.WeatherService;
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

    @Autowired
    private WeatherService weatherService;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb =  userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //this api is only created to demonstrate external api use
    @GetMapping
    public ResponseEntity<?> greetUser(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>("Hii "+ authentication.getName()+", weather feels like "+weatherService.getWeather("Mumbai").getCurrent().getFeelslike(),HttpStatus.OK);
    }



}

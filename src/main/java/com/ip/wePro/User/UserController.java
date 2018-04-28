package com.ip.wePro.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/userprofile")

public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getprofile/{id}")
    public User getProfileById(@PathVariable int id){
        return userService.getUserProfile(id);
    }

    @PutMapping("/updateProfile/{id}")
    public void updateProfileById(@RequestBody User profile){
        userService.updateProfile(profile);
    }

}
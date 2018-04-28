package com.ip.wePro.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    UserService userservice;

    @PostMapping("/register")
    public int registerUser(@RequestBody User user)
    {
        System.out.println(user.toString());
        return userservice.registeruser(user);
    }

    @GetMapping("/checkuser/{email}/{password}")
    public int checkuser(@PathVariable String email,@PathVariable String password )
    {
        return userservice.validateUser(email,password);
    }
}

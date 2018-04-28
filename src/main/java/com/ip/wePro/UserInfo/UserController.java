package com.ip.wePro.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/topics/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user, @PathVariable int id){
        userService.updateUser(id, user);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}

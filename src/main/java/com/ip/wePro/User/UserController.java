package com.ip.wePro.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.wePro.skills.Skills;

import org.springframework.web.bind.annotation.*;



/**
 * UserController is the server access point.
 * It is the host of the REST APIs to perform all the operations with respect to the project.
 */


@RestController
@RequestMapping("/userprofile")

// contriller for user profile handling
public class UserController {

    @Autowired
    private UserService userService;


    // controller to get the profile of the user by id
    @GetMapping("/getprofile/{id}")
    public User getProfileById(@PathVariable int id){
    	System.out.println("ID from client is =>"+id);
        return userService.getUserProfile(id);
    }
    
    // controller to update the profile by id
    @PutMapping("/updateProfile/{id}")
    public void updateProfileById(@RequestBody User profile){
        userService.updateProfile(profile);
    }

    /**
     * Add new User in the system using POST method.
     * @return return true if data successfully saved in the database.
     */
    @PostMapping("/register")
    public int registerUser(@RequestBody User user)
    {
        System.out.println(user.toString());
        return userService.registeruser(user);
    }

    /**
     * Get all the User in the system using GET method.
     * validate user with it's username and password with database.
     * @return return userid if the password matches.
     */



    @GetMapping("/checkuser/{email}/{password}")
    public int checkuser(@PathVariable String email,@PathVariable String password )
    {
        return userService.validateUser(email,password);
    }
    
    // controller to update the skills of the user when user updates his/her profile
    @PostMapping("/update/skills/{uid}")
    public int updateUserSkills(@RequestBody List<Skills> skills, @PathVariable Integer uid)
    {
        return userService.updateUserSkills(skills, uid);
    }
    
    // check the skills the user by id. (used to display the user details when user clicks on view profile)
    @GetMapping("/checkSkills/{uid}")
    public int checkSkills(@PathVariable Integer uid)
    {
    	Skills skills = new Skills();
    	skills.setName("JAVA");
    	skills.setId(1);
    	List<Skills> l = new ArrayList<>();
    	l.add(skills);
        return userService.updateUserSkills(l, uid);
    }

}

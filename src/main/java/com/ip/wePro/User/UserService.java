package com.ip.wePro.User;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.wePro.skills.Skills;
import com.ip.wePro.userSkills.UserSkills;
import com.ip.wePro.userSkills.UserSkillsRepository;

// service class to provide the services to the user controller class methods
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserSkillsRepository userSkillsRepository;

    // get the user profile from the database, to display to the user on view profile
    public User getUserProfile(int id) {
    	User user = userRepository.findById(id).get();
    	System.out.println("USer details :" + user.getEmail());
        return user; 
    }


    // update the user profile in the database
    public void updateProfile(User profile) {
        userRepository.save(profile);
    }



    /**
     * This is a service class which acts as a intermediate between the controller and the repository.
     * Controller will call the method in the service class to get the information as per rest call.
     * The service will invoke the repository methods which will fetch from the database and return the result.
     */

    /* ValidateUser helps to check whether entered username and password is correct or not and return
    * user ID of user on successfull validation*/
    public int validateUser(String email, String password) {

        User user1 = userRepository.getuserinfo(email);

        System.out.println(user1);

        if(user1.getPassword().equals(password))
        {
            return user1.getId();
        }
        else
        {
            return -1;
        }
    }

    /* registeruser help to create new register and return true if the data is successfully saved*/
    public int registeruser(User user) {

        userRepository.save(user);
        return 1;
    }


	public int updateUserSkills(List<Skills> skills, Integer uid) {
		// TODO Auto-generated method stub
    	
    	List<UserSkills> userSkills = userSkillsRepository.findAllByUserId(uid);
    	
    	/*for(UserSkills us: userSkills){
    		us.setRemoved(true);
    		userSkillsRepository.save(us);
    	}
    	for(Skills us: skills){
    		UserSkills userSk = new UserSkills();
    		userSk.setRemoved(false);
    		userSk.setUser_id(uid);
    		userSk.setSkill(us);
    		userSkillsRepository.save(userSk);
    	}*/
		
		return 1;
	}

}

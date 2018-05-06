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
        return userRepository.findById(id).get();
    }


    // update the user profile in the database
    public void updateProfile(User profile) {
        userRepository.save(profile);
    }

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

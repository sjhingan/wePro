package com.ip.wePro.userSkills;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.wePro.User.User;
import com.ip.wePro.User.UserRepository;
import com.ip.wePro.skills.Skills;

@Service
public class UserSkillsService {
	
	private static final Logger logger = Logger.getLogger("UserSkillsService");
	
	@Autowired
	UserSkillsRepository userSkillsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsersWithSkills(List<Integer> skills) throws InterruptedException {
        logger.info("getUserWithSkills: " + skills);
        List<Integer> userList = userSkillsRepository.findUsersWithSkills(skills);
        List<User> userInfo = userRepository.findAllUsers(userList);
        return userInfo;
    }

}

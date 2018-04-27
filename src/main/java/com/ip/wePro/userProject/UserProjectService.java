package com.ip.wePro.userProject;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.wePro.project.Project;


@Service
public class UserProjectService {

    @Autowired
    UserProjectRepository userProjectRepository;
    
    private static final Logger LOGGER = Logger.getLogger("UserProjectService");
    
    public List<Project> getOpenProjectsOfUser(Long userId) {
    	LOGGER.info("***************************inside method getOpenProjectsOfUser()**********************************");
        List<UserProject> userProjects = userProjectRepository.findOpenProjectsByUserId(userId);
        List<Project> results = new ArrayList<Project>();
        for(UserProject u: userProjects){
        	results.add(u.getProject());
        }
        LOGGER.info("OPEN userProjects info : "+userProjects);
    	return results;
    }

	public List<Project> getClosedProjectsByUserId(Long userId) {
		LOGGER.info("***************************inside method getClosedProjectsByUserId()**********************************");
		List<UserProject> userProjects = userProjectRepository.findClosedProjectsByUserId(userId);
		List<Project> results = new ArrayList<Project>();
        for(UserProject u: userProjects){
        	results.add(u.getProject());
        }
		LOGGER.info("CLOSED userProjects info : "+userProjects);
		return results;
	}
}

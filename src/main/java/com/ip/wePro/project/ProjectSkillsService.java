package com.ip.wePro.project;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * This is the service class for projectskills repository.
 * This class is used in other service class to get information regarding the skills of the project.
 */
public class ProjectSkillsService {

    @Autowired
    ProjectSkillsRepository projectSkillsRepository;

    /**
     * This will fetch all the skills for the given project id.
     * @param projectId project id.
     * @return list of projectskills.
     */
    public List<ProjectSkills> addProjectSkills(int projectId){
        return projectSkillsRepository.findAllSkillsByProjectId(projectId);
    }
}

package com.ip.wePro.project;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectSkillsService {

    @Autowired
    ProjectSkillsRepository projectSkillsRepository;

    public List<ProjectSkills> addProjectSkills(int projectId){
        return projectSkillsRepository.findAllSkillsByProjectId(projectId);
    }
}

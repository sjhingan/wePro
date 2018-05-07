package com.ip.wePro.skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is the Service class for the Skills table.
 * It acts as intermediate between the Controller and Repository.
 */
@Service
public class SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    /**
     * This will fetch all the skills saved in the table.
     * @return list of skill objects.
     */
    List<Skills> getAllSkills(){
        return skillsRepository.findAll();
    }
}

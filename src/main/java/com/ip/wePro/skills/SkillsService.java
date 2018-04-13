package com.ip.wePro.skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    List<Skills> getAllSkills(){
        return skillsRepository.findAll();
    }
}

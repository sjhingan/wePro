package com.ip.wePro.skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SkillsController is the server access point to get the skills.
 * It is the host of the REST APIs to perform all the operations with respect to the skills.
 */
@RestController
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    /**
     * This will fetch all the skills from the table.
     * @return list of skills object.
     */
    @RequestMapping(value = "/skills/all", method = RequestMethod.GET)
    List<Skills> getAllSkills(){
        return skillsService.getAllSkills();
    }
}

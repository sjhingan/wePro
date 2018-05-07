package com.ip.wePro.skills;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Skills Repository is the interface that will connect to database and
 * perform DML operations on Skills table.
 */
public interface SkillsRepository extends JpaRepository<Skills, Integer> {

}

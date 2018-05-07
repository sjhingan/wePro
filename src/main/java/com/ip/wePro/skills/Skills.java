package com.ip.wePro.skills;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This POJO class represents the Skills table in the database.
 */
@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    /**
     * Skills default constructor.
     */
    public Skills(){

    }

    /**
     * Skills parameterize constructor.
     * @param name name of the skill.
     */
    public Skills(String name) {
        this.name = name;
    }

    /**
     * Get the unique id of the skill.
     * @return id of the skill.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique id of the skill.
     * @param id id of the skill.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the skill.
     * @return skill name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name for the skill.
     * @param name skill name.
     */
    public void setName(String name) {
        this.name = name;
    }
}

package com.ip.wePro.User;

import javax.persistence.*;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ip.wePro.userSkills.UserSkills;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    
    private String dob;
    private String gender;
    private String address;
    
    private String phone;
    private String occupation;
    private String experience;
    private String description;
    @OneToMany(mappedBy="user_id")
    Set<UserSkills> userSkills;

    protected User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", email=" + email + ", lastname=" + lastname
				+ ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", phone="
				+ phone + ", occupation=" + occupation + ", experience=" + experience + ", description=" + description
				+ "]";
	}

	public User(int id, String firstname, String email, String lastname, String password, String dob, String gender,
			String address, String phone, String occupation, String experience, String description,
			Set<UserSkills> userSkills) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.email = email;
		this.lastname = lastname;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.occupation = occupation;
		this.experience = experience;
		this.description = description;
		this.userSkills = userSkills;
	}


	public Set<UserSkills> getUserSkills() {
		return userSkills;
	}


	public void setUserSkills(Set<UserSkills> userSkills) {
		this.userSkills = userSkills;
	}
}
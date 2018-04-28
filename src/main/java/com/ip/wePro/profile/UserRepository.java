package com.ip.wePro.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("Select A from User A where A.email = :email")
    User getuserinfo(@Param("email") String email);

    /*@Query("Insert into user_firstname,user_lastname,user_email,user_password")
    User adduser(String user_firstname, String user_lastname, String user_email, String user_password);*/
}

package com.ip.wePro.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// creating user repository to access the data from database

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("Select A from User A where A.email = :email")
    User getuserinfo(@Param("email") String email);


}
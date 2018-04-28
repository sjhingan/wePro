package com.ip.wePro.User;

import org.springframework.data.jpa.repository.JpaRepository;

// creating user repository to access the data from database

public interface UserRepository extends JpaRepository<User,Integer> {


}
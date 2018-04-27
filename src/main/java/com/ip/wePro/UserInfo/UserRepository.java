package com.ip.wePro.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findById(int id);
    boolean deleteById(int id);
}



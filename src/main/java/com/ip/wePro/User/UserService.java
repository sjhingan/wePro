package com.ip.wePro.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserProfile(int id) {
        return userRepository.findById(id).get();
    }


    public void updateProfile(User profile) {
        userRepository.save(profile);
    }


}
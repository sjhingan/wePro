package com.ip.wePro.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id);
    }

    public void addUser(User user){ userRepository.save(user); }

    public void updateUser(int id, User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


}

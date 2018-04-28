package com.ip.wePro.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int validateUser(String email, String password) {

        User user1 = userRepository.getuserinfo(email);

        System.out.println(user1);

        if(user1.getPassword().equals(password))
        {
            return user1.getId();
        }
        else
        {
            return -1;
        }
    }

    public int registeruser(User user) {

        userRepository.save(user);
        return 1;
    }

}

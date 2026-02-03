package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
         User newuser=new User();
         newuser.setName(user.getName());
         newuser.setEmail(user.getEmail());
         newuser.setPassword(user.getPassword());
         newuser.setTasks(user.getTasks());
        return  userRepository.save(newuser);
    }
}

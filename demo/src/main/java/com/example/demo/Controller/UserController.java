package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("TaskApp/User")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/getMeg")
    public String  getMessage(){
        return "Welcome to my app";
    }

    @PostMapping("addUser")
    public User addUser(@Valid @RequestBody User user){
         return userService.addUser(user);
    }

}

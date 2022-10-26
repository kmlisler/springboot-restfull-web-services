package com.kamilisler.rest.websevices.restfullwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser( @PathVariable Integer id){
        User user = userService.findUser(id);
        if (user == null){
            throw new UserNotFoundException("id : "+id );
        }
        return user;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
    }


}
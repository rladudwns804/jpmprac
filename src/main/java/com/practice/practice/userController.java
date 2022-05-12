package com.practice.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userapi")
public class userController {

    @Autowired
    UserRepository uRepo;

    @PostMapping(value="/adduser")
    public void createUser(@RequestBody User user){
        uRepo.save(user);
        System.out.println("Success!");
    }

    @GetMapping(value="/getuser")
    public User getuser(@RequestParam String username){
        return uRepo.findByUsername(username);
    }

}

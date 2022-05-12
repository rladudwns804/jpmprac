package com.practice.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/userapi")
public class userController {

    @Autowired
    UserRepository uRepo;
    @Autowired
    AccountRepository aRepo;

    @PostMapping(value="/adduser")
    public void createUser(@RequestBody User user){
        uRepo.save(user);
        System.out.println("Success!");
    }

    @GetMapping(value="/getuser")
    public User getuser(@RequestParam String username){
        return uRepo.findByUsername(username);
    }

    @PostMapping(value="/createchecking")
    public void createChecking(@RequestBody CheckingAccount checking, @RequestParam String username){
        aRepo.save(checking);
        User user = uRepo.findByUsername(username);
        user.setAccounts(checking);
        checking.setUser(user);
        checking.setDateOpened(Instant.now());
        uRepo.save(user);
        aRepo.save(checking);

    }


}

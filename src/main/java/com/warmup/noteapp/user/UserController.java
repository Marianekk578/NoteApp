package com.warmup.noteapp.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showUserPage(){
        return "user";
    }

    @GetMapping("/user/{id}")
    public Optional<User> showUserByID(@PathVariable long id){
            return userService.findUserByID(id);
        }

    @GetMapping("/user/all")
    public List<User> showAllUsers(){
        return userService.showAllUsers();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}


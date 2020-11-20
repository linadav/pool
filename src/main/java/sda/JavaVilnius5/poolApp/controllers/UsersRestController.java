package sda.JavaVilnius5.poolApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.JavaVilnius5.poolApp.exeptions.UserNotFoundException;
import sda.JavaVilnius5.poolApp.models.User;
import sda.JavaVilnius5.poolApp.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersRestController {
    @Autowired
    private UsersService usersService;

//    @GetMapping("/all")
    @GetMapping("")
    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }
    @PostMapping("")
    List<User> newUser(@RequestBody User user) {
        return usersService.newUser(user);
    }
    @GetMapping("/getuser/{id}")
    public User getUserById(@PathVariable Long id) throws UserNotFoundException {
        return usersService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    List<User> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        return usersService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    User updateUserById(@PathVariable Long id, @RequestBody User user) {
        return usersService.updateUserById(id, user);
    }
}



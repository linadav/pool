package sda.JavaVilnius5.poolApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sda.JavaVilnius5.poolApp.exeptions.ActivityNotFoundException;
import sda.JavaVilnius5.poolApp.exeptions.UserNotFoundException;
import sda.JavaVilnius5.poolApp.models.Activity;
import sda.JavaVilnius5.poolApp.models.User;
import sda.JavaVilnius5.poolApp.repositories.ActivitiesRepository;
import sda.JavaVilnius5.poolApp.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<User> getAllUsers() {
        return (List<User>) usersRepository.findAll();
    }

    public User getUserById(@PathVariable Long iduser) throws UserNotFoundException {
        User user = usersRepository.findById(iduser)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %s not found",
                        iduser)));
        return user;
    }
    public List<User> deleteUser(@PathVariable Long iduser) throws UserNotFoundException {
        usersRepository.findById(iduser)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %s not found",
                        iduser)));

        usersRepository.deleteById(iduser);
        return new ArrayList<User>();
    }

    public List<User> newUser(@RequestBody User user) {
        return Collections.singletonList(usersRepository.save(user));
    }

    public User updateUserById(@PathVariable Long id, @RequestBody User user) {
        user.setIduser(id);
        return this.usersRepository.save(user);
    }
}

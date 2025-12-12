package com.example.springHibernate.controllers;

import com.example.springHibernate.models.Post;
import com.example.springHibernate.models.User;
import com.example.springHibernate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }
    @GetMapping("user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("user/{id}/posts")
    public List<Post> getAllPostsByUser(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()) {
            return user.get().getPosts();
        }
        return null;
    }

    @GetMapping("users/location/{id}/users")
    public List<User> getUsersByLocation(@PathVariable Integer id) {
        return userService.getUsersByLocation(id);
    }

    @PostMapping ("users/addNew")
    public void AddUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("users/{id}/update")
    public void UpdateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}/delete")
    public void DeleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}

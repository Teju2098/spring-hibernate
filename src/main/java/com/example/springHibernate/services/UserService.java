package com.example.springHibernate.services;

import com.example.springHibernate.models.User;
import com.example.springHibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(Integer Id) {
        return userRepository.findById(Id);
    }

    public List<User> getUsersByLocation(Integer id) {
        return userRepository.findByLocationId(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}

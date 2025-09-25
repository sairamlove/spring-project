package com.klu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.klu.model.User;
import com.klu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;  // Use the correct repository

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a user
    public User registerUser(User user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);   
    }

    // Login user
    public boolean loginUser(String email, String rawPassword) {
        Optional<User> optionalUser = userRepository.findByEmail(email);  // ✅ Fixed line 27
        if (optionalUser.isEmpty()) return false;

        User user = optionalUser.get();
        return passwordEncoder.matches(rawPassword, (String) user.getPassword());
    }
}

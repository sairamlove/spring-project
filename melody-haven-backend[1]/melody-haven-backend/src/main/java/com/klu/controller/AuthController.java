package com.klu.controller;

	import com.klu.model.User;
	import com.klu.repository.UserRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	@RestController
	@RequestMapping("/auth")
	public class AuthController {

	    @Autowired
	    private UserRepository userRepository;

	    @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody User user) {
	        userRepository.save(user);
	        return ResponseEntity.ok("User registered successfully");
	    }
	}


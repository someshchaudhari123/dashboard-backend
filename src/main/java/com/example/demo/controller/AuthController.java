package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.payload.LoginRequest;
import com.example.demo.payload.LoginResponse;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://tubular-paprenjak-8caefe.netlify.app/") // allow your React frontend
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users/count")
    public ResponseEntity<Long> getUserCount() {
        long count = userRepository.count();
        return ResponseEntity.ok(count);
    }

    // LOGIN API
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {

        // find user by email
        Optional<User> userOpt = userRepository.findByEmail(loginRequest.getEmail());

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // check password
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                // login success
                LoginResponse response = new LoginResponse();
                response.setMessage("Login Successful");
                response.setEmail(user.getEmail());
                response.setName(user.getName());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body("Invalid password");
            }

        } else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }

}

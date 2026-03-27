package com.sachin.SecurityRoom.controller;

import com.sachin.SecurityRoom.Jwt.JwtService;
import com.sachin.SecurityRoom.dto.AuthResponse;
import com.sachin.SecurityRoom.dto.LoginRequest;
import com.sachin.SecurityRoom.dto.RegisterRequest;
import com.sachin.SecurityRoom.entity.user_auth;
import com.sachin.SecurityRoom.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;   // ✅ JwtService inject

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {

        userService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        try {

            // 1️⃣ Authenticate user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }

        // 2️⃣ Fetch user
        user_auth user = userService.findByEmail(request.getEmail());

        // 3️⃣ Generate JWT token using JwtService
        String token = jwtService.generateToken(user.getEmail());

        // 4️⃣ Response
        AuthResponse response = AuthResponse.builder()
                .token(token)
                .onboardingCompleted(user.isOnboardingCompleted())
                .build();

        return ResponseEntity.ok(response);
    }
}
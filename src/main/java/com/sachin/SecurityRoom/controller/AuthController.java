package com.sachin.SecurityRoom.controller;

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

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {

        userService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // 🔥 Yaha se important part start hota hai

        user_auth user = userService.findByEmail(request.getEmail());

        String dummyToken = "TEMP_TOKEN"; // Abhi JWT nahi laga rahe

        AuthResponse response = AuthResponse.builder()
                .token(dummyToken)
                .onboardingCompleted(user.isOnboardingCompleted())
                .build();

        return ResponseEntity.ok(response);
    }
}
package com.sachin.controller;

import com.sachin.dto.ProfileRequest;
import com.sachin.dto.ProfileResponse;
import com.sachin.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public String createProfile(@RequestBody ProfileRequest request,
                                Authentication authentication) {

        String email = authentication.getName();
        profileService.createOrUpdateProfile(request, email);

        return "Profile saved successfully";
    }

    @GetMapping
    public ProfileResponse getProfile(Authentication authentication) {

        String email = authentication.getName();
        return profileService.getProfile(email);
    }
}
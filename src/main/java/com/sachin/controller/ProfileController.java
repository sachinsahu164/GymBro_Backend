package com.sachin.controller;

import com.sachin.dto.ProfileRequest;
import com.sachin.dto.ProfileResponse;
import com.sachin.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    // 🔥 Create or update profile
    @PostMapping
    public String createProfile(@RequestBody ProfileRequest request) {
        profileService.createOrUpdateProfile(request);
        return "Profile saved successfully";
    }

    // 🔥 Get profile
    @GetMapping
    public ProfileResponse getProfile() {
        return profileService.getProfile();
    }
}
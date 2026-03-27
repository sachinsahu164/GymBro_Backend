package com.sachin.service;

import com.sachin.SecurityRoom.entity.user_auth;
import com.sachin.SecurityRoom.repository.UserRepository;
import com.sachin.dto.ProfileRequest;
import com.sachin.dto.ProfileResponse;
import com.sachin.entity.UserProfile;
import com.sachin.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userAuthRepository;
    private final UserProfileRepository userProfileRepository;

    // 🔥 Get current logged-in user from JWT
    private user_auth getCurrentUser() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        return userAuthRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ✅ CREATE OR UPDATE PROFILE
    @Override
    public void createOrUpdateProfile(ProfileRequest request) {

        user_auth userAuth = getCurrentUser();

        UserProfile profile = userProfileRepository.findByUserAuth(userAuth)
                .orElse(UserProfile.builder()
                        .userAuth(userAuth)
                        .build());

        profile.setAge(request.getAge());
        profile.setUsername(request.getUsername());
        profile.setHeight(request.getHeight());
        profile.setWeight(request.getWeight());
        profile.setGoal(request.getGoal());
        profile.setActivityLevel(request.getActivityLevel());
        // profile.setDietPreference(request.getDietPreference());

        userProfileRepository.save(profile);

        // Mark onboarding completed
        userAuth.setOnboardingCompleted(true);
        userAuthRepository.save(userAuth);
    }

    // ✅ GET PROFILE
    @Override
    public ProfileResponse getProfile() {

        user_auth userAuth = getCurrentUser();

        UserProfile profile = userProfileRepository.findByUserAuth(userAuth)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        return ProfileResponse.builder()
                .age(profile.getAge())
                .username(profile.getUsername())
                .height(profile.getHeight())
                .weight(profile.getWeight())
                .goal(profile.getGoal())
                .activityLevel(profile.getActivityLevel())
                //.dietPreference(profile.getDietPreference())
                .build();
    }
}
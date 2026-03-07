package com.sachin.service;


import com.sachin.SecurityRoom.entity.user_auth;
import com.sachin.SecurityRoom.repository.UserRepository;
import com.sachin.dto.ProfileRequest;
import com.sachin.dto.ProfileResponse;
import com.sachin.entity.UserProfile;
import com.sachin.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userAuthRepository;
    private final UserProfileRepository userProfileRepository;

    @Override
    public void createOrUpdateProfile(ProfileRequest request, String email) {

        user_auth userAuth = userAuthRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

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

        userAuth.setOnboardingCompleted(true);
        userAuthRepository.save(userAuth);
    }

    @Override
    public ProfileResponse getProfile(String email) {

        user_auth userAuth = userAuthRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserProfile profile = userProfileRepository.findByUserAuth(userAuth)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        return ProfileResponse.builder()
                .age(profile.getAge())
                .username(profile.getUsername())
                .height(profile.getHeight())
                .weight(profile.getWeight())
                .goal(profile.getGoal())
                .ActivityLevel(profile.getActivityLevel())
                //.dietPreference(profile.getDietPreference())
                .build();
    }
}
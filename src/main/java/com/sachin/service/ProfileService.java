package com.sachin.service;

import com.sachin.dto.ProfileRequest;
import com.sachin.dto.ProfileResponse;

public interface ProfileService {
    void createOrUpdateProfile(ProfileRequest request); // remove email
    ProfileResponse getProfile();
}
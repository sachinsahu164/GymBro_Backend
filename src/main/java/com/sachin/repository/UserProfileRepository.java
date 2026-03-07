package com.sachin.repository;


import com.sachin.SecurityRoom.entity.user_auth;
import com.sachin.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUserAuth(user_auth userAuth);
}
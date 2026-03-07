package com.sachin.SecurityRoom.repository;

import com.sachin.SecurityRoom.entity.user_auth;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<user_auth, Long> {

    Optional<user_auth> findByEmail(String email);



}

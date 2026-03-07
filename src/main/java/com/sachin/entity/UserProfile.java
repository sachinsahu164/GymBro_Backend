package com.sachin.entity;

import com.sachin.SecurityRoom.entity.user_auth;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Integer age;
    private String gender;
    private Double height;
    private Double weight;
    private String goal;
    private String ActivityLevel;
  //  private String dietPreference;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private user_auth userAuth;
}
package com.sachin.SecurityRoom.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Name is required")
    private String username;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
//    @Pattern(
//            regexp = "^(?=.*[A-Z])(?=.*[0-9]).{6,}$",
//            message = "Password must contain at least one uppercase letter and one number"
//    )
    private String password;
}
package com.project.SMS.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    private Long id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters !!!")
    private String name;

    @Email(message = "Email address is not valid !!!")
    @NotEmpty(message = "Email is required !!!")
    private String email;

    @NotEmpty
    @Size(min = 8, message = "Password must be min of 8 chars  !!!")
    private String password;

    private String about;

    private String imageName;

    private int age;

    private Set<RoleDto> roles = new HashSet<>();
}

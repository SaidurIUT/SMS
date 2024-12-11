package com.project.SMS.service;

import com.project.SMS.payloads.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    UserDto registerNewUser(UserDto userDto, Integer roleId);

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

    public String validateVerificationToken(String token) ;

    String forgotPassword(String email);

    String resetPassword(String token , String newPassword);

}

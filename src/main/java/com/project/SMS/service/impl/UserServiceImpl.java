package com.project.SMS.service.impl;


import com.project.SMS.entities.*;
import com.project.SMS.exception.ResourceNotFoundException;
import com.project.SMS.payloads.UserDto;
import com.project.SMS.repository.*;
import com.project.SMS.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private TeacherInfoRepo teacherInfoRepo;

    @Autowired
    private AdminInfoRepo adminInfoRepo;

    @Autowired
    private StudentInfoRepo studentInfoRepo;


    @Transactional
    @Override
    public UserDto registerNewUser(UserDto userDto, Integer roleId) {
        User user = this.modelMapper.map(userDto, User.class);

        // Encode the password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));


        // Get the role
        Role role = this.roleRepo.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "Id", roleId));

        user.setRole(role);

        User newUser = this.userRepo.save(user);

        if(roleId==502) {
            user.setImageName("teacher.png");
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setUser(newUser);
            this.teacherInfoRepo.save(teacherInfo);

        }
        else if (roleId == 503) {
            user.setImageName("student.png");
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setUser(newUser);
            this.studentInfoRepo.save(studentInfo);

        }
        else if (roleId == 501) {
            user.setImageName("admin.png");
            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setUser(newUser);
            this.adminInfoRepo.save(adminInfo);
        }
        return this.modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }

    @Override
    public String validateVerificationToken(String token) {
        return "";
    }

    @Override
    public String forgotPassword(String email) {
        return "";
    }

    @Override
    public String resetPassword(String token, String newPassword) {
        return "";
    }

    public User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);

        // user.setId(userDto.getId());
        // user.setName(userDto.getName());
        // user.setEmail(userDto.getEmail());
        // user.setAbout(userDto.getAbout());
        // user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}

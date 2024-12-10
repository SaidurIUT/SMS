package com.project.SMS.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentInfoDto {

    private Long id;

    private String grade;

    private String guardianName;

    private String schoolName;

    private Long userId; // Reference to the associated User entity

//    private Set<Long> classIds; // IDs of classes the student is enrolled in

//    private Set<Long> commentIds; // IDs of comments made by the student
}

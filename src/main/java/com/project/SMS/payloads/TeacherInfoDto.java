package com.project.SMS.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TeacherInfoDto {

    private Long id;

    private String subjectSpecialization;

    private int yearsOfExperience;

    private Long userId; // Reference to the associated User entity

    private Long departmentId; // Reference to the associated Department entity
}
